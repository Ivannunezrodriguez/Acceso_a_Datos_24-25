package dao;

import com.mongodb.client.MongoCollection;
import database.ConexionDB;
import model.Alumno;
import org.bson.Document;

import java.util.Scanner;

public class AlumnoDAO {
    private final MongoCollection<Alumno> alumnosCollection;
    private final Scanner scanner = new Scanner(System.in);

    // constructor que resibe una conexion a la base de datos
    public AlumnoDAO(ConexionDB conexionDB) {
        this.alumnosCollection = conexionDB.getAlumnosCollection();
    }

    // metodo para insertar un nuevo alumno en la coleccion
    public void insertarAlumno() {
        System.out.println("insertando un nuevo alumno...");
        Alumno alumno = new Alumno();
        System.out.print("nombre: ");
        alumno.setName(scanner.nextLine());
        System.out.print("edad: ");
        alumno.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.print("género: ");
        alumno.setGender(scanner.nextLine());
        System.out.print("email: ");
        alumno.setEmail(scanner.nextLine());
        System.out.print("teléfono: ");
        alumno.setPhone(scanner.nextLine());
        System.out.print("calificación: ");
        alumno.setCalification(Integer.parseInt(scanner.nextLine()));
        System.out.print("grado superior: ");
        alumno.setHigherGrade(scanner.nextLine());
        System.out.print("rating: ");
        alumno.setRating(Double.parseDouble(scanner.nextLine()));
        alumnosCollection.insertOne(alumno);
        System.out.println("alumno insertado correctamente.");
    }

    // metodo para mostrar todos los alumnos
    public void mostrarAlumnos() {
        System.out.println("mostrando todos los alumnos...");
        for (Alumno alumno : alumnosCollection.find()) {
            System.out.println(alumno);
        }
    }

    // metodo para buscar un alumno por su email
    public void buscarAlumno() {
        System.out.print("ingrese el email del alumno a buscar: ");
        String email = scanner.nextLine();
        Alumno alumno = alumnosCollection.find(new Document("email", email)).first();
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("alumno no encontrado.");
        }
    }

    // metodo para dar de baja a los alumnos xon calificacion 5 o superior
    public void darBajaAlumnos() {
        alumnosCollection.deleteMany(new Document("calification", new Document("$gte", 5)));
        System.out.println("alumnos con calificación 5 o superior eliminados correctamente.");
    }
}
