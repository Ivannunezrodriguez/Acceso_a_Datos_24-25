package controller;

import dao.CocheDAO;
import model.Coche;

import java.sql.SQLException;
import java.util.Scanner;

public class CocheFun {
    private final CocheDAO cocheDAO = new CocheDAO();

    public void nuevoCoche(Scanner scanner) {
        System.out.print("Marca del coche: ");
        String marca = scanner.next();
        System.out.print("Modelo del coche: ");
        String modelo = scanner.next();
        System.out.print("Año del coche: ");
        int anio = scanner.nextInt();

        try {
            cocheDAO.nuevoCoche(new Coche(0, marca, modelo, anio));
            System.out.println("Coche añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al añadir coche: " + e.getMessage());
        }
    }

    public void borrarCoche(Scanner scanner) {
        System.out.print("ID del coche a borrar: ");
        int id = scanner.nextInt();

        try {
            cocheDAO.borrarCoche(id);
            System.out.println("Coche borrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al borrar coche: " + e.getMessage());
        }
    }

    public void buscarCoche(Scanner scanner) {
        System.out.print("ID del coche a consultar: ");
        int id = scanner.nextInt();

        try {
            Coche coche = cocheDAO.buscaCochePorId(id);
            if (coche != null) {
                System.out.println("Coche encontrado: " + coche);
            } else {
                System.out.println("Coche no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar coche: " + e.getMessage());
        }
    }

    public void modificarCoche(Scanner scanner) {
        System.out.print("ID del coche a modificar: ");
        int id = scanner.nextInt();

        System.out.print("Nueva marca: ");
        String marca = scanner.next();
        System.out.print("Nuevo modelo: ");
        String modelo = scanner.next();
        System.out.print("Nuevo año: ");
        int anio = scanner.nextInt();

        try {
            cocheDAO.actulizaCoche(id, marca, modelo, anio);
            System.out.println("Coche actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar coche: " + e.getMessage());
        }
    }

    public void listarCoches() {
        try {
            cocheDAO.listarCoches().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error al listar coches: " + e.getMessage());
        }
    }
}
