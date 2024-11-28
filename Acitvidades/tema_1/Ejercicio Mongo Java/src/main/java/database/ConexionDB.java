package database;

import com.mongodb.MongoClientSettings;
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

public class ConexionDB {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Alumno> alumnosCollection;
    private MongoCollection<Profesor> profesoresCollection;

    // constructor que inicializa la conexion a la base de datos
    public ConexionDB() {

        // configurar el proveedor de codecs para soportar pojos
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(pojoCodecProvider));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString(DBScheme.LINK_CONEXION))
                .codecRegistry(pojoCodecRegistry)
                .build();

        // crear el cliente mongo usando la configuracion
        mongoClient = MongoClients.create(settings);

        // obtener la base de datos "centro_estudios"
        database = mongoClient.getDatabase(DBScheme.DATABASE);

        // obtener las colecciones especificando el tipo de pojo
        alumnosCollection = database.getCollection(DBScheme.COLECION_ALUMNOS, Alumno.class);
        profesoresCollection = database.getCollection(DBScheme.COLECCION_PROFESOR, Profesor.class);
    }

    // metodo para obtener la coleccion de alumnos
    public MongoCollection<Alumno> getAlumnosCollection() {
        return alumnosCollection;
    }

    // metodo para obtener la coleccion de profesores
    public MongoCollection<Profesor> getProfesoresCollection() {
        return profesoresCollection;
    }

    // metodo para cerrar la conexion a la base de datos
    public void cerrarConexion() {
        mongoClient.close();
    }
}
