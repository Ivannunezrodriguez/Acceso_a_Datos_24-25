package Database;


public interface SchemaDB {
    String DB_URL = "jdbc:mysql://127.0.0.1:3306/gestion_usuarios";
    String DB_USER = "root";
    String DB_PASS = "";
    String TABLA_USUARIOS = "usuarios";
    String COL_ID = "id";
    String COL_NOMBRE = "nombre";
    String COL_APELLIDO = "apellido";
    String COL_CORREO = "correo";
    String COL_PASS = "pass";
}
