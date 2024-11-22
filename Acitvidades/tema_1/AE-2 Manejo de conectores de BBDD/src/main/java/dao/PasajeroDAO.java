package dao;

import database.DatabaseConnection;
import database.DatabaseSchema;
import model.Pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {

    private Connection connection;
    private PreparedStatement prepareStatement;
    // statement
    private ResultSet resultSet;

    // constructor por defecto
    public PasajeroDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void añadirPasajero(Pasajero pasajero) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_PASAJEROS + " (" +
                DatabaseSchema.COLUMN_PASAJERO_NOMBRE + ", " +
                DatabaseSchema.COLUMN_PASAJERO_EDAD + ", " +
                DatabaseSchema.COLUMN_PASAJERO_PESO + ") VALUES (?, ?, ?)";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, pasajero.getNombre());
        prepareStatement.setInt(2, pasajero.getEdad());
        prepareStatement.setDouble(3, pasajero.getPeso());
        prepareStatement.executeUpdate();

    }

    public Pasajero getPasajeroById(int id) throws SQLException {
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_PASAJEROS +
                " WHERE " + DatabaseSchema.COLUMN_PASAJERO_ID + " = ?";


        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        resultSet = prepareStatement.executeQuery();
        if (resultSet.next()) {
            return new Pasajero(resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                    resultSet.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                    resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                    resultSet.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO));
        }
        return null;
    }


    public void borrarPasajero(int id) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_PASAJEROS + " WHERE " + DatabaseSchema.COLUMN_PASAJERO_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        prepareStatement.executeUpdate();
    }


    public List<Pasajero> listarPasajeros() throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_PASAJEROS;

        prepareStatement = (PreparedStatement) connection.createStatement();
        resultSet = prepareStatement.executeQuery(query);
        while (resultSet.next()) {
            pasajeros.add(new Pasajero(resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                    resultSet.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                    resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                    resultSet.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO)));
        }

        return pasajeros;
    }


    public void añadirPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_COCHE_PASAJERO + " (" +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + ", " +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID + ") VALUES (?, ?)";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, cocheId);
        prepareStatement.setInt(2, pasajeroId);
        prepareStatement.executeUpdate();
    }


    public void borrarPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_COCHE_PASAJERO +
                " WHERE " + DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + " = ? AND " +
                DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, cocheId);
        prepareStatement.setInt(2, pasajeroId);
        prepareStatement.executeUpdate();
    }


    public List<Pasajero> listarPasajerosPorCoche(int cocheId) throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String query = "SELECT p.* FROM " + DatabaseSchema.TABLE_PASAJEROS + " p " +
                "JOIN " + DatabaseSchema.TABLE_COCHE_PASAJERO + " cp ON p." +
                DatabaseSchema.COLUMN_PASAJERO_ID + " = cp." + DatabaseSchema.COLUMN_COCHE_PASAJERO_PASAJERO_ID +
                " WHERE cp." + DatabaseSchema.COLUMN_COCHE_PASAJERO_COCHE_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, cocheId);
        resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            pasajeros.add(new Pasajero(resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_ID),
                    resultSet.getString(DatabaseSchema.COLUMN_PASAJERO_NOMBRE),
                    resultSet.getInt(DatabaseSchema.COLUMN_PASAJERO_EDAD),
                    resultSet.getDouble(DatabaseSchema.COLUMN_PASAJERO_PESO)));
        }
        return pasajeros;
    }


}

