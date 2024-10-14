import controller.Coche;
import controller.GestorCoches;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        GestorCoches gestor = new GestorCoches();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Introduce qué quieres hacer:");
            System.out.println("1. Añadir coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Consultar coche por ID");
            System.out.println("4. Listar coches");
            System.out.println("5. Exportar coches a archivo CSV");
            System.out.println("6. Guardar y salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestor.agregarCoche();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del coche a borrar: ");
                    int idBorrar = scanner.nextInt();
                    gestor.eliminarCocheId(idBorrar);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del coche a buscar: ");
                    int muestraId = scanner.nextInt();
                    Coche cocheEncontrado = gestor.buscarCochePorId(muestraId);
                    if (cocheEncontrado != null) {
                        System.out.println("Coche encontrado: " + cocheEncontrado);
                    } else {
                        System.out.println("No se encontró ningún coche con el ID " + muestraId);
                    }
                    break;
                case 4:
                    gestor.mostrarCoches();
                    break;
                case 5:
                    String nombreArchivoCSV = "src/resources/coches.csv";
                    gestor.exportarCochesACSV(nombreArchivoCSV);
                    break;
                case 6:
                    gestor.guardarCochesEnArchivo();
                    System.out.println("Coches guardados en " + gestor.getNombreArchivo());
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }
}