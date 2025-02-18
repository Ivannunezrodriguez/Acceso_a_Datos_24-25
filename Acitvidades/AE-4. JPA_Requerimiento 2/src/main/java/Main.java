import controller.CursoController;
import database.HibernateUtil;
import model.*;

public class Main {
    public static void main(String[] args) {
        CursoController cursoController = new CursoController();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Jose@example.com", "1234");
        Usuario usuario2 = new Usuario("Alba@example.com", "4321");
        Usuario usuario3 = new Usuario("Daniel@example.com", "5678");
        Usuario usuario4 = new Usuario("Ivan@example.com", "8765");

        cursoController.agregarUsuario(usuario1);
        cursoController.agregarUsuario(usuario2);
        cursoController.agregarUsuario(usuario3);
        cursoController.agregarUsuario(usuario4);

        // Crear perfiles
        cursoController.agregarPerfil(new Perfil("Jose", "Perez", usuario1));
        cursoController.agregarPerfil(new Perfil("Alba", "Nuñez", usuario2));
        cursoController.agregarPerfil(new Perfil("Daniel", "Gomez", usuario3));
        cursoController.agregarPerfil(new Perfil("Ivan", "Nuñez", usuario4));

        // Crear estudiantes
        cursoController.agregarEstudiante(new Estudiante("Jose", usuario1.getEmail(), usuario1));
        cursoController.agregarEstudiante(new Estudiante("Alba", usuario2.getEmail(), usuario2));
        cursoController.agregarEstudiante(new Estudiante("Daniel", usuario3.getEmail(), usuario3));
        cursoController.agregarEstudiante(new Estudiante("Ivan", usuario4.getEmail(), usuario4));

        // Crear profesores
        Profesor profesor1 = new Profesor("Manuel", "SGE");
        Profesor profesor2 = new Profesor("Ana", "FOL");
        Profesor profesor3 = new Profesor("Daniel", "DEVops");

        cursoController.agregarProfesor(profesor1);
        cursoController.agregarProfesor(profesor2);
        cursoController.agregarProfesor(profesor3);

        // Crear cursos
        cursoController.agregarCurso(new Curso("DAM", 40, profesor1));
        cursoController.agregarCurso(new Curso("DAM2", 50, profesor2));

        // Mostrar resultados
        cursoController.listarProfesores();
        cursoController.listarEstudiantes();
        cursoController.listarCursos();
        cursoController.listarUsuarios();
        cursoController.listarPerfiles();


        HibernateUtil.close();
    }
}
