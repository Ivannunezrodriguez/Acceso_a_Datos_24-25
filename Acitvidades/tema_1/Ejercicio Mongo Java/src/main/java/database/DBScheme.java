package database;

public interface DBScheme {

    String USER= "unir";
    String PASS= "unir";
    String DATABASE = "centro_estudios";
    String COLECION_ALUMNOS = "alumnos";
    String COLECCION_PROFESOR = "profesores";
    String LINK_CONEXION="mongodb+srv://"+USER+":"+PASS+"@cluster0.qrerh.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
}
