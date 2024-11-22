package controller;


import dao.CocheDAO;
import model.Coche;

import java.sql.SQLException;
import java.util.List;

public class CocheFun {
    private final CocheDAO cocheDAO = new CocheDAO();

    // Crear un nuevo coche
    public void nuevoCoche(String marca, String modelo, int anio) throws SQLException {
        Coche coche = new Coche(0, marca, modelo, anio);
        cocheDAO.nuevoCoche(coche);
    }

    // Consultar un coche por ID
    public Coche buscarCochePorId(int id) throws SQLException {
        return cocheDAO.buscaCochePorId(id);
    }

    // Actualizar un coche por ID
    public void actulizarCoche(int id, String marca, String modelo, int anio) throws SQLException {
        cocheDAO.actulizaCoche(id, marca, modelo, anio);
    }

    // Borrar un coche por ID
    public void borrarCoche(int id) throws SQLException {
        cocheDAO.borrarCoche(id);
    }

    // Listar todos los coches
    public List<Coche> listarCoches() throws SQLException {
        return cocheDAO.listarCoches();
    }

    // Mostrar todos los coches en formato legible
    public void mostrarCoches() throws SQLException {
        List<Coche> coches = listarCoches();
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            System.out.println("\n===== LISTADO DE COCHES =====");
            for (Coche coche : coches) {
                System.out.println("ID: " + coche.getId() + ", Marca: " + coche.getMarca() +
                        ", Modelo: " + coche.getModelo() + ", Año: " + coche.getAnio());
            }
        }
    }
}
