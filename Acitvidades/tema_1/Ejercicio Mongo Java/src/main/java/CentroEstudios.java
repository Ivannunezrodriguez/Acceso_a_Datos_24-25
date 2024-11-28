import dao.AlumnoDAO;
import dao.ProfesorDAO;
import database.ConexionDB;

import java.util.Scanner;

public class CentroEstudios {
    private final Scanner scanner = new Scanner(System.in);
    private final ProfesorDAO profesorDAO;
    private final AlumnoDAO alumnoDAO;

    // constructor qe inicializa la conexion y los daos
    public CentroEstudios() {
        ConexionDB conexionDB = new ConexionDB();
        this.profesorDAO = new ProfesorDAO(conexionDB);
        this.alumnoDAO = new AlumnoDAO(conexionDB);
        ejecutarMenu();
        conexionDB.cerrarConexion();
    }

    // metodo main para iniciar el programa
    public static void main(String[] args) {
        new CentroEstudios();
    }

    // metodo quee ejecuta el menu principal
    public void ejecutarMenu() {
        int option;
        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> profesorDAO.insertarProfesor();
                case 2 -> alumnoDAO.insertarAlumno();
                case 3 -> mostrarTodos();
                case 4 -> profesorDAO.mostrarProfesores();
                case 5 -> alumnoDAO.mostrarAlumnos();
                case 6 -> alumnoDAO.buscarAlumno();
                case 7 -> profesorDAO.buscarProfesor();
                case 8 -> profesorDAO.actualizarProfesor();
                case 9 -> alumnoDAO.darBajaAlumnos();
                case 10 -> System.out.println("saliendo...");
                default -> System.out.println("opción inválida, por favor intente nuevamente.");
            }
        } while (option != 10);
    }

    // metodo para mostrar el menu de opciones
    private void showMenu() {
        System.out.println("\nmenú de opciones:");
        System.out.println("1- insertar un profesor");
        System.out.println("2- insertar un alumno");
        System.out.println("3- mostrar todos los datos");
        System.out.println("4- mostrar profesores");
        System.out.println("5- mostrar alumnos");
        System.out.println("6- buscar alumno por mail");
        System.out.println("7- buscar profesor por edad");
        System.out.println("8- actualizar calificación profesor");
        System.out.println("9- dar de baja alumnos con suspenso");
        System.out.println("10- salir");
        System.out.print("seleccione una opción: ");
    }

    // metodo para mostrar todos los profesores y alumnos
    private void mostrarTodos() {
        System.out.println("mostrando todos los profesores y alumnos...");
        profesorDAO.mostrarProfesores();
        alumnoDAO.mostrarAlumnos();
    }
}
