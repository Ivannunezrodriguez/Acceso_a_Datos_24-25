package controller;


import dao.PasajeroDAO;
import model.Pasajero;

import java.sql.SQLException;
import java.util.List;

public class PasajeroFun {
    private final PasajeroDAO pasajeroDAO = new PasajeroDAO();

    // Crear un nuevo pasajero
    public void nuevoPasajero(String nombre, int edad, double peso) throws SQLException {
        Pasajero pasajero = new Pasajero(0, nombre, edad, peso);
        pasajeroDAO.añadirPasajero(pasajero);
    }

    // Consultar un pasajero por ID
    public Pasajero buscaPasajeroPorId(int id) throws SQLException {
        return pasajeroDAO.getPasajeroById(id);
    }

    // Borrar un pasajero por ID
    public void borrarPasajero(int id) throws SQLException {
        pasajeroDAO.borrarPasajero(id);
    }

    // Listar todos los pasajeros
    public List<Pasajero> listarPasajeros() throws SQLException {
        return pasajeroDAO.listarPasajeros();
    }

    // Mostrar todos los pasajeros en formato legible
    public void mostrarPasajeros() throws SQLException {
        List<Pasajero> pasajeros = listarPasajeros();
        if (pasajeros.isEmpty()) {
            System.out.println("No hay pasajeros registrados.");
        } else {
            System.out.println("\n===== LISTADO DE PASAJEROS =====");
            for (Pasajero pasajero : pasajeros) {
                System.out.println("ID: " + pasajero.getId() + ", Nombre: " + pasajero.getNombre() +
                        ", Edad: " + pasajero.getEdad() + ", Peso: " + pasajero.getPeso());
            }
        }
    }

    // Añadir un pasajero a un coche
    public void añadirPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        pasajeroDAO.añadirPasajeroEnCoche(pasajeroId, cocheId);
    }

    // Eliminar un pasajero de un coche
    public void borrarPasajeroEnCoche(int pasajeroId, int cocheId) throws SQLException {
        pasajeroDAO.borrarPasajeroEnCoche(pasajeroId, cocheId);
    }

    // Listar todos los pasajeros de un coche
    public List<Pasajero> listarPasajerosPorCoche(int cocheId) throws SQLException {
        return pasajeroDAO.listarPasajerosPorCoche(cocheId);
    }

    // Mostrar los pasajeros de un coche en formato legible
    public void mostrarPasajerosDeCoche(int cocheId) throws SQLException {
        List<Pasajero> pasajeros = listarPasajerosPorCoche(cocheId);
        if (pasajeros.isEmpty()) {
            System.out.println("El coche con ID " + cocheId + " no tiene pasajeros asociados.");
        } else {
            System.out.println("\n===== PASAJEROS DEL COCHE (ID: " + cocheId + ") =====");
            for (Pasajero pasajero : pasajeros) {
                System.out.println("ID: " + pasajero.getId() + ", Nombre: " + pasajero.getNombre() +
                        ", Edad: " + pasajero.getEdad() + ", Peso: " + pasajero.getPeso());
            }
        }
    }
}
