import controller.CocheFun;
import controller.PasajeroFun;

import java.util.Scanner;

public class Main {
    private static final CocheFun cocheFun = new CocheFun();
    private static final PasajeroFun pasajeroFun = new PasajeroFun();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por ID");
            System.out.println("3. Consulta coche por ID");
            System.out.println("4. Modificar coche por ID");
            System.out.println("5. Listado de coches");
            System.out.println("6. Gestión de pasajeros");
            System.out.println("7. Terminar el programa");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> cocheFun.nuevoCoche(scanner);
                case 2 -> cocheFun.borrarCoche(scanner);
                case 3 -> cocheFun.buscarCoche(scanner);
                case 4 -> cocheFun.modificarCoche(scanner);
                case 5 -> cocheFun.listarCoches();
                case 6 -> menuGestionPasajeros(scanner);
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 7);
    }

    private static void menuGestionPasajeros(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n===== MENÚ GESTIÓN DE PASAJEROS =====");
            System.out.println("1. Añadir nuevo pasajero");
            System.out.println("2. Borrar pasajero por ID");
            System.out.println("3. Consultar pasajero por ID");
            System.out.println("4. Listar todos los pasajeros");
            System.out.println("5. Añadir pasajero a coche");
            System.out.println("6. Eliminar pasajero de coche");
            System.out.println("7. Listar pasajeros de un coche");
            System.out.println("8. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> pasajeroFun.nuevoPasajero(scanner);
                case 2 -> pasajeroFun.borrarPasajero(scanner);
                case 3 -> pasajeroFun.consultarPasajero(scanner);
                case 4 -> pasajeroFun.listarPasajeros();
                case 5 -> pasajeroFun.añadirPasajeroACoche(scanner);
                case 6 -> pasajeroFun.eliminarPasajeroDeCoche(scanner);
                case 7 -> pasajeroFun.listarPasajerosDeCoche(scanner);
                case 8 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 8);
    }
}
