package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import database.DatabaseConnection;
import model.Alumno;
import org.bson.Document;

public class AlumnosDAO {
 MongoCollection alumnosCollection;

    public AlumnosDAO() {
        alumnosCollection = new DatabaseConnection().getAlumnosCollection();
    }
    public void insertarAlumno(Alumno alumno) {
        alumnosCollection.insertOne(alumno.toDocument());
        System.out.println("Alumno insertado correctamente.");
    }

    public void mostrarAlumnos() {
        try (MongoCursor cursor = alumnosCollection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(Alumno.fromDocument((Document) cursor.next()));
            }
        }
    }

    public Alumno buscarAlumnoPorEmail(String email) {
        Document query = new Document("email", email);
        Document result = (Document) alumnosCollection.find(query).first();
        return result != null ? Alumno.fromDocument(result) : null;
    }

    public void darDeBajaAlumnos() {
        alumnosCollection.deleteMany(new Document("calification", new Document("$gte", 5)));
        System.out.println("Se han dado de baja todos los alumnos con calificación >= 5.");
    }
}
