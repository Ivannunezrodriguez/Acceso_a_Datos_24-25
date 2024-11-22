package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DatabaseSchema.DB_URL, DatabaseSchema.DB_USER, DatabaseSchema.DB_PASSWORD);
            System.out.println("Conexión a la base de datos establecida con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
