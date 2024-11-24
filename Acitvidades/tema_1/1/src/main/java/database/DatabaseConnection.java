package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Alumno;
import model.Profesor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DatabaseConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://"+DBScheme.USER+":"+DBScheme.PASS+"@cluster0.qrerh.mongodb.net/";
    private static final String DATABASE_NAME = "centro_estudios";
    private MongoClient mongoClient;
    private CodecProvider codecProvider;
    CodecRegistry codecRegistry;

    public  DatabaseConnection() {
        codecProvider = PojoCodecProvider.builder().automatic(true).build();
        codecRegistry = CodecRegistries.fromRegistries(
                MongoClients.create().getCodecRegistry(),
                CodecRegistries.fromProviders(codecProvider)
        );
        mongoClient = MongoClients.create(CONNECTION_STRING);
    }
    public MongoCollection getAlumnosCollection() {
        MongoDatabase database = mongoClient.getDatabase("academia").withCodecRegistry(codecRegistry);
        return database.getCollection("alumnos", Alumno.class);
    }

    public MongoCollection getProfesoresCollection(){
        MongoDatabase database = mongoClient.getDatabase("academia").withCodecRegistry(codecRegistry);
        return database.getCollection("Profesores", Profesor.class);
    }}
