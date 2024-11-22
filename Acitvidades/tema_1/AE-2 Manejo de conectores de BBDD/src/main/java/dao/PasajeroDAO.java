package dao;
import model.Pasajero;
import database.DatabaseConnection;
import database.DatabaseSchema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {
    // Método para añadir un nuevo pasajero
    public void añadirPasajero(Pasajero pasajero) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_PASAJEROS + " (" +
                DatabaseSchema.COLUMN_PASAJERO_NOMBRE + ", " +
                DatabaseSchema.COLUMN_PASAJERO_EDAD + ", " +
                DatabaseSchema.COLUMN_PASAJERO_PESO + ") VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pasajero.getNombre());
            stmt.setInt(2, pasajero.getEdad());
            stmt.setDouble(3, pasajero.getPeso());
            stmt.executeUpdate();
        }
    }

    // Método para obtener un pasajero por su ID
    public Pasajero getPasajeroById(int id) throws SQLException {
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_PASAJEROS + " WHERE " + DatabaseSchema.COLUMN_PASAJERO_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pasajero(rs.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                            rs.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                            rs.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                            rs.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO));
                }
            }
        }
        return null;
    }

    // Método para borrar un pasajero por ID
    public void borrarPasajero(int id) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_PASAJEROS + " WHERE " + DatabaseSchema.COLUMN_PASAJERO_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos los pasajeros
    public List<Pasajero> listarPasajeros() throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_PASAJEROS;
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                pasajeros.add(new Pasajero(rs.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                        rs.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                        rs.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                        rs.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO)));
            }
        }
        return pasajeros;
    }

    // Método para añadir un pasajero a un coche
    public void añadirPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_COCHE_PASAJERO + " (" +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + ", " +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID + ") VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cocheId);
            stmt.setInt(2, pasajeroId);
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un pasajero de un coche
    public void borrarPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_COCHE_PASAJERO +
                " WHERE " + DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + " = ? AND " +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cocheId);
            stmt.setInt(2, pasajeroId);
            stmt.executeUpdate();
        }
    }

    // Método para listar los pasajeros asociados a un coche
    public List<Pasajero> listarPasajerosPorCoche(int cocheId) throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String query = "SELECT p.* FROM " + DatabaseSchema.TABLE_PASAJEROS + " p " +
                "JOIN " + DatabaseSchema.TABLE_COCHE_PASAJERO + " cp ON p." +
                DatabaseSchema.COLUMN_PASAJERO_ID + " = cp." + DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID +
                " WHERE cp." + DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cocheId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pasajeros.add(new Pasajero(rs.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                            rs.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                            rs.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                            rs.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO)));
                }
            }
        }
        return pasajeros;
    }
}
