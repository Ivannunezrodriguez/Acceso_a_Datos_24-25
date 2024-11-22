package controller;

import dao.PasajeroDAO;
import model.Pasajero;

import java.sql.SQLException;
import java.util.Scanner;

public class PasajeroFun {
    private final PasajeroDAO pasajeroDAO = new PasajeroDAO();

    public void nuevoPasajero(Scanner scanner) {
        System.out.print("Nombre del pasajero: ");
        String nombre = scanner.next();
        System.out.print("Edad del pasajero: ");
        int edad = scanner.nextInt();
        System.out.print("Peso del pasajero: ");
        double peso = scanner.nextDouble();

        try {
            pasajeroDAO.añadirPasajero(new Pasajero(0, nombre, edad, peso));
            System.out.println("Pasajero añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al añadir pasajero: " + e.getMessage());
        }
    }

    public void borrarPasajero(Scanner scanner) {
        System.out.print("ID del pasajero a borrar: ");
        int id = scanner.nextInt();

        try {
            pasajeroDAO.borrarPasajero(id);
            System.out.println("Pasajero borrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al borrar pasajero: " + e.getMessage());
        }
    }

    public void consultarPasajero(Scanner scanner) {
        System.out.print("ID del pasajero a consultar: ");
        int id = scanner.nextInt();

        try {
            Pasajero pasajero = pasajeroDAO.getPasajeroById(id);
            if (pasajero != null) {
                System.out.println("Pasajero encontrado: " + pasajero);
            } else {
                System.out.println("Pasajero no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar pasajero: " + e.getMessage());
        }
    }

    public void listarPasajeros() {
        try {
            pasajeroDAO.listarPasajeros().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error al listar pasajeros: " + e.getMessage());
        }
    }

    public void añadirPasajeroACoche(Scanner scanner) {
        System.out.print("ID del pasajero: ");
        int pasajeroId = scanner.nextInt();
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            pasajeroDAO.añadirPasajeroEnCoche(pasajeroId, cocheId);
            System.out.println("Pasajero añadido al coche correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al añadir pasajero al coche: " + e.getMessage());
        }
    }

    public void eliminarPasajeroDeCoche(Scanner scanner) {
        System.out.print("ID del pasajero: ");
        int pasajeroId = scanner.nextInt();
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            pasajeroDAO.borrarPasajeroEnCoche(pasajeroId, cocheId);
            System.out.println("Pasajero eliminado del coche correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar pasajero del coche: " + e.getMessage());
        }
    }

    public void listarPasajerosDeCoche(Scanner scanner) {
        System.out.print("ID del coche: ");
        int cocheId = scanner.nextInt();

        try {
            var pasajeros = pasajeroDAO.listarPasajerosPorCoche(cocheId);
            if (pasajeros.isEmpty()) {
                System.out.println("El coche con ID " + cocheId + " no tiene pasajeros asociados.");
            } else {
                pasajeros.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pasajeros del coche: " + e.getMessage());
        }
    }
}
