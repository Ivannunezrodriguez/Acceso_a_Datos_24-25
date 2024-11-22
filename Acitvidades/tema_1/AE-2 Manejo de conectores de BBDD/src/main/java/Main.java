

import controller.CocheFun;
import controller.PasajeroFun;
import model.Coche;
import model.Pasajero;

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
                case 1 -> añadirCoche(scanner);
                case 2 -> borrarCoche(scanner);
                case 3 -> consultarCoche(scanner);
                case 4 -> modificarCoche(scanner);
                case 5 -> listarCoches();
                case 6 -> menuGestionPasajeros(scanner);
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 7);
    }

    // Métodos para las opciones del menú principal
    private static void añadirCoche(Scanner scanner) {
        System.out.print("Marca del coche: ");
        String marca = scanner.next();
        System.out.print("Modelo del coche: ");
        String modelo = scanner.next();
        System.out.print("Año del coche: ");
        int anio = scanner.nextInt();

        try {
            cocheFun.nuevoCoche(marca, modelo, anio);
            System.out.println("Coche añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al añadir coche: " + e.getMessage());
        }
    }

    private static void borrarCoche(Scanner scanner) {
        System.out.print("ID del coche a borrar: ");
        int id = scanner.nextInt();

        try {
            cocheFun.borrarCoche(id);
            System.out.println("Coche borrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar coche: " + e.getMessage());
        }
    }

    private static void consultarCoche(Scanner scanner) {
        System.out.print("ID del coche a consultar: ");
        int id = scanner.nextInt();

        try {
            Coche coche = cocheFun.buscarCochePorId(id);
            if (coche != null) {
                System.out.println("Coche encontrado: ");
                coche.mostrarCoche();
            } else {
                System.out.println("Coche no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar coche: " + e.getMessage());
        }
    }

    private static void modificarCoche(Scanner scanner) {
        System.out.print("ID del coche a modificar: ");
        int id = scanner.nextInt();

        System.out.print("Nueva marca: ");
        String marca = scanner.next();
        System.out.print("Nuevo modelo: ");
        String modelo = scanner.next();
        System.out.print("Nuevo año: ");
        int anio = scanner.nextInt();

        try {
            cocheFun.actulizarCoche(id, marca, modelo, anio);
            System.out.println("Coche actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar coche: " + e.getMessage());
        }
    }

    private static void listarCoches() {

        try {
            cocheFun.listarCoches().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar coches: " + e.getMessage());
        }
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
                case 1 -> añadirPasajero(scanner);
                case 2 -> borrarPasajero(scanner);
                case 3 -> consultarPasajero(scanner);
                case 4 -> listarPasajeros();
                case 5 -> añadirPasajeroACoche(scanner);
                case 6 -> eliminarPasajeroDeCoche(scanner);
                case 7 -> listarPasajerosDeCoche(scanner);
                case 8 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 8);
    }

    // Métodos para las opciones del submenú de gestión de pasajeros
    private static void añadirPasajero(Scanner scanner) {
        System.out.print("Nombre del pasajero: ");
        String nombre = scanner.next();
        System.out.print("Edad del pasajero: ");
        int edad = scanner.nextInt();
        System.out.print("Peso del pasajero: ");
        double peso = scanner.nextDouble();

        try {
            pasajeroFun.nuevoPasajero(nombre, edad, peso);
            System.out.println("Pasajero añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al añadir pasajero: " + e.getMessage());
        }
    }

    private static void borrarPasajero(Scanner scanner) {
        System.out.print("ID del pasajero a borrar: ");
        int id = scanner.nextInt();

        try {
            pasajeroFun.borrarPasajero(id);
            System.out.println("Pasajero borrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar pasajero: " + e.getMessage());
        }
    }

    private static void consultarPasajero(Scanner scanner) {
        System.out.print("ID del pasajero a consultar: ");
        int id = scanner.nextInt();

        try {
            Pasajero pasajero = pasajeroFun.buscaPasajeroPorId(id);
            if (pasajero != null) {
                System.out.println("Pasajero encontrado: " );
                pasajero.mostrarPasajero();
            } else {
                System.out.println("Pasajero no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar pasajero: " + e.getMessage());
        }
    }

    private static void listarPasajeros() {
        try {
            pasajeroFun.listarPasajeros().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar pasajeros: " + e.getMessage());
        }
    }

    private static void añadirPasajeroACoche(Scanner scanner) {
        System.out.print("ID del pasajero: ");
        int pasajeroId = scanner.nextInt();
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            pasajeroFun.añadirPasajeroEnCoche(pasajeroId, cocheId);
            System.out.println("Pasajero añadido al coche correctamente.");
        } catch (Exception e) {
            System.out.println("Error al añadir pasajero al coche: " + e.getMessage());
        }
    }

    private static void eliminarPasajeroDeCoche(Scanner scanner) {
        System.out.print("ID del pasajero: ");
        int pasajeroId = scanner.nextInt();
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            pasajeroFun.borrarPasajeroEnCoche(pasajeroId, cocheId);
            System.out.println("Pasajero eliminado del coche correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar pasajero del coche: " + e.getMessage());
        }
    }

    private static void listarPasajerosDeCoche(Scanner scanner) {
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            var pasajeros = pasajeroFun.listarPasajerosPorCoche(cocheId);
            if (pasajeros.isEmpty()) {
                System.out.println("El coche con ID " + cocheId + " no tiene pasajeros asociados.");
            } else {
                System.out.println("\n===== PASAJEROS DEL COCHE (ID: " + cocheId + ") =====");
                pasajeros.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al listar pasajeros del coche: " + e.getMessage());
        }
    }
}
