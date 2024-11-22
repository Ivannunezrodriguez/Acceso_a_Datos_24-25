package database;

public class DatabaseSchema {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/gestion_coches";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String TABLE_COCHES = "coches";
    public static final String COLUMN_COCHE_ID = "id";
    public static final String COLUMN_COCHE_MARCA = "marca";
    public static final String COLUMN_COCHE_MODELO = "modelo";
    public static final String COLUMN_COCHE_ANIO = "anio";
    public static final String TABLE_PASAJEROS = "pasajeros";
    public static final String COLUMN_PASAJERO_ID = "id";
    public static final String COLUMN_PASAJERO_NOMBRE = "nombre";
    public static final String COLUMN_PASAJERO_EDAD = "edad";
    public static final String COLUMN_PASAJERO_PESO = "peso";
    public static final String TABLE_COCHE_PASAJERO = "coche_pasajero";
    public static final String COLUMN_COCHE_PASAJERO_COCHE_ID = "coche_id";
    public static final String COLUMN_COCHE_PASAJERO_PASAJERO_ID = "pasajero_id";
}
