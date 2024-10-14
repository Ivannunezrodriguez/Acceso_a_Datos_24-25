package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorCoches {
    private final ArrayList<Coche> coches;
    private String nombreArchivo = "src/resources/coches.dat";
    private final Scanner scanner;

    public GestorCoches() {
        coches = new ArrayList<>();
        scanner = new Scanner(System.in);
        cargarCochesDesdeArchivo();
    }

    public void cargarCochesDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length != 5) {
                    System.err.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }
                Coche coche = new Coche();
                try {
                    coche.setId(Integer.parseInt(datos[0]));
                    coche.setMarca(datos[1]);
                    coche.setModelo(datos[2]);
                    coche.setColor(datos[3]);
                    coche.setMatricula(datos[4]);
                    coches.add(coche);
                } catch (NumberFormatException e) {
                    System.err.println("ID no válido en la línea: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            System.err.println("Error al cargar los coches desde el archivo: " + e.getMessage());
        }
    }

    public void guardarCochesEnArchivo() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Coche coche : coches) {
                printWriter.println(coche.getId() + "," + coche.getMarca() + "," + coche.getModelo() + "," + coche.getColor() + "," + coche.getMatricula());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los coches en el archivo: " + e.getMessage());
        }
    }

    public void agregarCoche() {
        Scanner scanner = new Scanner(System.in);
        Coche coche = new Coche();
        System.out.print("Ingrese el ID del coche: ");
        int id = scanner.nextInt();


        if (buscarCochePorId(id) != null) {
            System.out.println("Error: Ya existe un coche con el ID " + id);
            return;
        }

        System.out.print("Ingrese la matrícula del coche: ");
        String matricula = scanner.next();


        if (buscarCochePorMatricula(matricula) != null) {
            System.out.println("Error: Ya existe un coche con la matrícula " + matricula);
            return;
        }

        coche.setId(id);
        coche.setMatricula(matricula);
        System.out.print("Ingrese la Marca del coche: ");
        coche.setMarca(scanner.next());
        System.out.print("Ingrese el modelo del coche: ");
        coche.setModelo(scanner.next());
        System.out.print("Ingrese el color del coche: ");
        coche.setColor(scanner.next());

        coches.add(coche);
        guardarCochesEnArchivo();
        System.out.println("controller.Coche añadido con éxito.");
    }

    public Coche buscarCochePorMatricula(String matricula) {
        for (Coche coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return coche;
            }
        }
        return null;
    }

    public Coche buscarCochePorId(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                return coche;
            }
        }
        return null;
    }

    public void eliminarCocheId(int id) {
        if (coches.removeIf(coche -> coche.getId() == id)) {
            System.out.println("controller.Coche eliminado.");
        } else {
            System.out.println("No se encontró el coche con ID: " + id);
        }
        guardarCochesEnArchivo();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        }
    }

    public void exportarCochesACSV(String nombreArchivoCSV) {
        try (FileWriter writer = new FileWriter(nombreArchivoCSV)) {
            writer.write("ID;Marca;Modelo;Color;Matricula\n");
            for (Coche coche : coches) {
                writer.write(coche.getId() + ";" + coche.getMarca() + ";" + coche.getModelo() + ";" + coche.getColor() + ";" + coche.getMatricula() + "\n");
            }
            System.out.println("Coches exportados a " + nombreArchivoCSV);
        } catch (IOException e) {
            System.err.println("Error al exportar coches a CSV: " + e.getMessage());
        }
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
