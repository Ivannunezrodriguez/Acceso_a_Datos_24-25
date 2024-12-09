package DAO;

import Database.DBConnection;
import Database.SchemaDB;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
                SchemaDB.TABLA_USUARIOS, SchemaDB.COL_NOMBRE, SchemaDB.COL_APELLIDO, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getApellido());
        ps.setString(3, usuario.getCorreo());
        ps.setString(4, usuario.getPass());

        try {
            ps.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: el correo ya está registrado.");
            return false;
        }
    }

    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        String query = String.format("SELECT %s, %s, %s FROM %s",
                SchemaDB.COL_ID, SchemaDB.COL_NOMBRE, SchemaDB.COL_CORREO, SchemaDB.TABLA_USUARIOS);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            usuarios.add(new Usuario(rs.getInt(SchemaDB.COL_ID), rs.getString(SchemaDB.COL_NOMBRE), "", rs.getString(SchemaDB.COL_CORREO), ""));
        }
        return usuarios;
    }

    public boolean comprobarCredenciales(String correo, String pass) throws SQLException {
        String query = String.format("SELECT %s FROM %s WHERE %s = ? AND %s = ?",
                SchemaDB.COL_ID, SchemaDB.TABLA_USUARIOS, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, correo);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public ArrayList<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        String query = String.format("SELECT * FROM %s", SchemaDB.TABLA_USUARIOS);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            usuarios.add(new Usuario(rs.getInt(SchemaDB.COL_ID), rs.getString(SchemaDB.COL_NOMBRE), rs.getString(SchemaDB.COL_APELLIDO), rs.getString(SchemaDB.COL_CORREO), rs.getString(SchemaDB.COL_PASS)));
        }
        return usuarios;
    }
}