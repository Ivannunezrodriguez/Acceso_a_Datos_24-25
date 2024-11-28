package dao;

import com.mongodb.client.MongoCollection;
import database.ConexionDB;
import model.Profesor;

import java.util.Arrays;
import java.util.Scanner;

public class ProfesorDAO {
    private final MongoCollection<Profesor> profesoresCollection;
    private final Scanner scanner = new Scanner(System.in);

    // constructor que resibe una conexion a la base de datos
    public ProfesorDAO(ConexionDB conexionDB) {
        this.profesoresCollection = conexionDB.getProfesoresCollection();  // ahora se espera MongoCollection<Profesor>
    }

    // metodo para insertar un nuevo profesor en la coleccion
    public void insertarProfesor() {
        System.out.println("insertando un nuevo profesor...");
        Profesor profesor = new Profesor();
        System.out.print("nombre: ");
        profesor.setNombre(scanner.nextLine());
        System.out.print("edad: ");
        profesor.setEdad(Integer.parseInt(scanner.nextLine()));
        System.out.print("género: ");
        profesor.setGender(scanner.nextLine());
        System.out.print("email: ");
        profesor.setEmail(scanner.nextLine());
        System.out.print("teléfono: ");
        profesor.setPhone(scanner.nextLine());
        System.out.print("título: ");
        profesor.setTitle(scanner.nextLine());
        System.out.print("materias (separadas por comas): ");
        profesor.setSubjects(Arrays.asList(scanner.nextLine().split(",")));
        System.out.print("rating: ");
        profesor.setRating(Double.parseDouble(scanner.nextLine()));
        profesoresCollection.insertOne(profesor);
        System.out.println("profesor insertado correctamente.");
    }

    // metodo para mostrar todos los profesores
    public void mostrarProfesores() {
        System.out.println("mostrando todos los profesores...");
        for (Profesor profesor : profesoresCollection.find()) {
            System.out.println(profesor);
        }
    }

    // metodo para buscar profesores por rango de edad
    public void buscarProfesor() {
        System.out.print("ingrese el rango de edad (mínima y máxima separadas por coma): ");
        String[] rangos = scanner.nextLine().split(",");
        int edadMin = Integer.parseInt(rangos[0].trim());
        int edadMax = Integer.parseInt(rangos[1].trim());
        for (Profesor profesor : profesoresCollection.find(new org.bson.Document("age", new org.bson.Document("$gte", edadMin).append("$lte", edadMax)))) {
            System.out.println(profesor);
        }
    }

    // metodo para actualizar la calificacion de un profesor
    public void actualizarProfesor() {
        System.out.print("ingrese el email del profesor a actualizar: ");
        String email = scanner.nextLine();
        System.out.print("ingrese la nueva calificación: ");
        double nuevaCalificacion = Double.parseDouble(scanner.nextLine());
        org.bson.Document update = new org.bson.Document("$set", new org.bson.Document("rating", nuevaCalificacion));
        profesoresCollection.updateOne(new org.bson.Document("email", email), update);
        System.out.println("profesor actualizado correctamente.");
    }
}
