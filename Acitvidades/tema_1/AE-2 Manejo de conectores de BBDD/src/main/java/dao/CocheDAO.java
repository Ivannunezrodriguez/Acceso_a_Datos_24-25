package dao;

import database.DatabaseConnection;
import database.DatabaseSchema;
import model.Coche;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {
    // Método para añadir un nuevo coche
    public void nuevoCoche(Coche coche) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_COCHES + " (" +
                DatabaseSchema.COLUMN_COCHE_MARCA + ", " +
                DatabaseSchema.COLUMN_COCHE_MODELO + ", " +
                DatabaseSchema.COLUMN_COCHE_ANIO + ") VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, coche.getMarca());
            stmt.setString(2, coche.getModelo());
            stmt.setInt(3, coche.getAnio());
            stmt.executeUpdate();
        }
    }

    // Método para obtener un coche por su ID
    public Coche buscaCochePorId(int id) throws SQLException {
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_COCHES + " WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Coche(rs.getInt(DatabaseSchema.COLUMN_COCHE_ID),
                            rs.getString(DatabaseSchema.COLUMN_COCHE_MARCA),
                            rs.getString(DatabaseSchema.COLUMN_COCHE_MODELO),
                            rs.getInt(DatabaseSchema.COLUMN_COCHE_ANIO));
                }
            }
        }
        return null;
    }

    // Método para actualizar un coche
    public void actulizaCoche(int id, String marca, String modelo, int anio) throws SQLException {
        String query = "UPDATE " + DatabaseSchema.TABLE_COCHES + " SET " +
                DatabaseSchema.COLUMN_COCHE_MARCA + " = ?, " +
                DatabaseSchema.COLUMN_COCHE_MODELO + " = ?, " +
                DatabaseSchema.COLUMN_COCHE_ANIO + " = ? WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setInt(3, anio);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    // Método para borrar un coche por ID
    public void borrarCoche(int id) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_COCHES + " WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos los coches
    public List<Coche> listarCoches() throws SQLException {
        List<Coche> coches = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_COCHES;
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                coches.add(new Coche(rs.getInt(DatabaseSchema.COLUMN_COCHE_ID),
                        rs.getString(DatabaseSchema.COLUMN_COCHE_MARCA),
                        rs.getString(DatabaseSchema.COLUMN_COCHE_MODELO),
                        rs.getInt(DatabaseSchema.COLUMN_COCHE_ANIO)));
            }
        }
        return coches;
    }
}
