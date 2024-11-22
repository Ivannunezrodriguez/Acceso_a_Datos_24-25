package dao;

import database.DatabaseConnection;
import database.DatabaseSchema;
import model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {
    private Connection connection;
    private PreparedStatement prepareStatement;
    private ResultSet resultSet;

    public CocheDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void nuevoCoche(Coche coche) throws SQLException {
        String query = "INSERT INTO " + DatabaseSchema.TABLE_COCHES + " (" +
                DatabaseSchema.COLUMN_COCHE_MARCA + ", " +
                DatabaseSchema.COLUMN_COCHE_MODELO + ", " +
                DatabaseSchema.COLUMN_COCHE_ANIO + ") VALUES (?, ?, ?)";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, coche.getMarca());
        prepareStatement.setString(2, coche.getModelo());
        prepareStatement.setInt(3, coche.getAnio());
        prepareStatement.executeUpdate();

    }


    public Coche buscaCochePorId(int id) throws SQLException {
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_COCHES +
                " WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        resultSet = prepareStatement.executeQuery();
        if (resultSet.next()) {
            return new Coche(resultSet.getInt(DatabaseSchema.COLUMN_COCHE_ID),
                    resultSet.getString(DatabaseSchema.COLUMN_COCHE_MARCA),
                    resultSet.getString(DatabaseSchema.COLUMN_COCHE_MODELO),
                    resultSet.getInt(DatabaseSchema.COLUMN_COCHE_ANIO));
        }
        return null;
    }


    public void actulizaCoche(int id, String marca, String modelo, int anio) throws SQLException {
        String query = "UPDATE " + DatabaseSchema.TABLE_COCHES + " SET " +
                DatabaseSchema.COLUMN_COCHE_MARCA + " = ?, " +
                DatabaseSchema.COLUMN_COCHE_MODELO + " = ?, " +
                DatabaseSchema.COLUMN_COCHE_ANIO + " = ? WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, marca);
        prepareStatement.setString(2, modelo);
        prepareStatement.setInt(3, anio);
        prepareStatement.setInt(4, id);
        prepareStatement.executeUpdate();

    }


    public void borrarCoche(int id) throws SQLException {
        String query = "DELETE FROM " + DatabaseSchema.TABLE_COCHES +
                " WHERE " + DatabaseSchema.COLUMN_COCHE_ID + " = ?";

        prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();

    }


    public ArrayList<Coche> listarCoches() throws SQLException {
        ArrayList<Coche> coches = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseSchema.TABLE_COCHES;

        prepareStatement = connection.prepareStatement(query);
        resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                coches.add(new Coche(resultSet.getInt(DatabaseSchema.COLUMN_COCHE_ID),
                        resultSet.getString(DatabaseSchema.COLUMN_COCHE_MARCA),
                        resultSet.getString(DatabaseSchema.COLUMN_COCHE_MODELO),
                        resultSet.getInt(DatabaseSchema.COLUMN_COCHE_ANIO)));
            }

        return coches;
    }
}
