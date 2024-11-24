import dao.AlumnosDAO;
import dao.ProfesoresDAO;

import model.Alumno;
import model.Profesor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AlumnosDAO alumnosDAO = new AlumnosDAO();
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> insertarProfesor(profesoresDAO, scanner);
                case 2 -> insertarAlumno(alumnosDAO, scanner);
                case 3 -> mostrarTodos(alumnosDAO, profesoresDAO);
                case 4 -> profesoresDAO.mostrarProfesores();
                case 5 -> alumnosDAO.mostrarAlumnos();
                case 6 -> buscarAlumno(alumnosDAO, scanner);
                case 7 -> buscarProfesor(profesoresDAO, scanner);
                case 8 -> actualizarProfesor(profesoresDAO, scanner);
                case 9 -> darDeBajaAlumnos(alumnosDAO);
                case 10 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 10);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("""
                1- Insertar un profesor
                2- Insertar un alumno
                3- Mostrar todos los datos
                4- Mostrar profesores
                5- Mostrar alumnos
                6- Buscar alumno
                7- Buscar profesor
                8- Actualizar profesor
                9- Dar de baja alumnos
                10- Salir
                Seleccione una opción:
                """);
    }

    private static void insertarProfesor(ProfesoresDAO profesoresDAO, Scanner scanner) {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String gender = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Asignaturas (separadas por comas): ");
        String[] subjects = scanner.nextLine().split(",");

        Profesor profesor = new Profesor(null, name, age, gender, email, phone, List.of(subjects), title);
        profesoresDAO.insertarProfesor(profesor);
    }

    private static void insertarAlumno(AlumnosDAO alumnosDAO, Scanner scanner) {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String gender = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Calificación: ");
        int calification = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Grado Superior: ");
        String higherGrade = scanner.nextLine();

        Alumno alumno = new Alumno(null, name, age, gender, email, phone, calification, higherGrade);
        alumnosDAO.insertarAlumno(alumno);
    }

    private static void mostrarTodos(AlumnosDAO alumnosDAO, ProfesoresDAO profesoresDAO) {
        System.out.println("---- Alumnos ----");
        alumnosDAO.mostrarAlumnos();
        System.out.println("---- Profesores ----");
        profesoresDAO.mostrarProfesores();
    }

    private static void buscarAlumno(AlumnosDAO alumnosDAO, Scanner scanner) {
        System.out.print("Ingrese el email del alumno: ");
        String email = scanner.nextLine();
        Alumno alumno = alumnosDAO.buscarAlumnoPorEmail(email);
        if (alumno != null) {
            System.out.println("Alumno encontrado: " + alumno);
        } else {
            System.out.println("No se encontró un alumno con ese email.");
        }
    }

    private static void buscarProfesor(ProfesoresDAO profesoresDAO, Scanner scanner) {
        System.out.print("Edad mínima: ");
        int minAge = scanner.nextInt();
        System.out.print("Edad máxima: ");
        int maxAge = scanner.nextInt();
        scanner.nextLine();
        profesoresDAO.buscarProfesorPorRangoEdad(minAge, maxAge);
    }

    private static void actualizarProfesor(ProfesoresDAO profesoresDAO, Scanner scanner) {
        System.out.print("Ingrese el email del profesor a actualizar: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese la nueva calificación: ");
        int newRating = scanner.nextInt();

        profesoresDAO.actualizarProfesorPorEmail(email, newRating);
    }

    private static void darDeBajaAlumnos(AlumnosDAO alumnosDAO) {
        alumnosDAO.darDeBajaAlumnos();
    }
}
