import DAO.UsuarioDAO;
import Database.DBConnection;
import Model.Usuario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionUsuarios {
    public static void main(String[] args) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenú de Gestión de Usuarios");
                System.out.println("1. Registrar usuario");
                System.out.println("2. Listar usuarios");
                System.out.println("3. Comprobar credenciales");
                System.out.println("4. Exportar usuarios");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        String pass = scanner.nextLine();
                        if (usuarioDAO.registrarUsuario(new Usuario(nombre, apellido, correo, pass))) {
                            System.out.println("Usuario registrado con éxito.");
                        }
                        break;

                    case 2:
                        ArrayList<Usuario> usuarios = usuarioDAO.listarUsuarios();
                        System.out.println("Lista de usuarios:");
                        usuarios.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Correo: ");
                        String loginCorreo = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        String loginPass = scanner.nextLine();
                        if (usuarioDAO.comprobarCredenciales(loginCorreo, loginPass)) {
                            System.out.println("Login correcto.");
                        } else {
                            System.out.println("Login incorrecto.");
                        }
                        break;

                    case 4:
                        File outputFolder = new File("src/main/java/Output");
                        if (!outputFolder.exists()) {
                            outputFolder.mkdirs();
                        }

                        ArrayList<Usuario> todosLosUsuarios = usuarioDAO.obtenerTodosLosUsuarios();
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/Output/usuarios.obj"))) {
                            oos.writeObject(todosLosUsuarios);
                            System.out.println("Usuarios exportados con éxito a src/main/java/Output/usuarios.obj.");
                        } catch (IOException e) {
                            System.out.println("Error al exportar usuarios.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        DBConnection.closeConnection();
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 5);

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}