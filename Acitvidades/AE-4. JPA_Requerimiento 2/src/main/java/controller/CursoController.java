package controller;

import dao.*;
import model.*;

public class CursoController {
    private final CursoDAO cursoDAO = new CursoDAO();
    private final EstudianteDAO estudianteDAO = new EstudianteDAO();
    private final ProfesorDAO profesorDAO = new ProfesorDAO();
    private final PerfilDAO perfilDAO = new PerfilDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void agregarEstudiante(Estudiante estudiante) {
        estudianteDAO.agregarEstudiante(estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        profesorDAO.agregarProfesor(profesor);
    }

    public void agregarCurso(Curso curso) {
        cursoDAO.agregarCurso(curso);
    }

    public void agregarPerfil(Perfil perfil) {
        perfilDAO.agregarPerfil(perfil);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    public void listarCursos() {
        cursoDAO.obtenerTodosLosCursos().forEach(c -> System.out.println("Curso: " + c.getNombre() + " - " + c.getDuracionHoras() + " horas"));
    }

    public void listarEstudiantes() {
        estudianteDAO.obtenerTodosLosEstudiantes().forEach(e -> System.out.println("Estudiante: " + e.getNombre() + " - " + e.getEmail()));
    }

    public void listarProfesores() {
        profesorDAO.obtenerTodosLosProfesores().forEach(p -> System.out.println("Profesor: " + p.getNombre() + " - " + p.getEspecialidad()));
    }

    public void listarUsuarios() {
        usuarioDAO.listarUsuarios().forEach(u -> System.out.println("Usuario: " + u.getId() + " - " + u.getEmail()));
    }

    public void listarPerfiles() {
        perfilDAO.listarPerfil().forEach(p -> System.out.println("Perfil: " + p.getId() + " - " + p.getNombre() + " " + p.getApellido()));
    }
}
