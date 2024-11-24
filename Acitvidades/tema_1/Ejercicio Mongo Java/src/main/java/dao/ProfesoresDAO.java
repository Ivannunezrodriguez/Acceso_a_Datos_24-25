package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database.DatabaseConnection;
import model.Profesor;
import org.bson.Document;

public class ProfesoresDAO {
    MongoCollection profesoresCollection;

    public ProfesoresDAO() {
     profesoresCollection = new DatabaseConnection().getProfesoresCollection();

    }

    public void insertarProfesor(Profesor profesor) {
        profesoresCollection.insertOne(profesor.toDocument());
        System.out.println("Profesor insertado correctamente.");
    }

    public void mostrarProfesores() {
        try (MongoCursor cursor = profesoresCollection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(Profesor.fromDocument((Document) cursor.next()));
            }
        }
    }

    public void buscarProfesorPorRangoEdad(int minAge, int maxAge) {
        for (Object profesor : profesoresCollection.find(new Document("age", new Document("$gte", minAge).append("$lte", maxAge)))) {
            System.out.println(Profesor.fromDocument((Document) profesor));
        }
    }

    public void actualizarProfesorPorEmail(String email, int newRating) {
        Document update = new Document("$set", new Document("rating", newRating));
        profesoresCollection.updateOne(new Document("email", email), update);
        System.out.println("Profesor actualizado correctamente.");
    }
}
