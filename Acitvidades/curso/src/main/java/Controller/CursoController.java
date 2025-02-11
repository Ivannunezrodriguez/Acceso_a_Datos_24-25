package Controller;

import DAO.CursoDAO;
import DAO.EstudianteDAO;
import DAO.ProfesorDAO;
import Model.Curso;
import Model.Estudiante;
import Model.Profesor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CursoController {
    private final CursoDAO cursoDAO;
    private final EstudianteDAO estudianteDAO;
    private final ProfesorDAO profesorDAO;


    public CursoController(EntityManager em) {
        this.cursoDAO = new CursoDAO(em);
        this.estudianteDAO = new EstudianteDAO(em);
        this.profesorDAO = new ProfesorDAO(em);
    }


    public void listarCursos() {
        System.out.println("-----Lista de cursos:-----");

        for (Curso curso: cursoDAO.obtenerTodosLosCursos()) {
            System.out.println("Curso: "+curso.getNombre()+" "+curso.getDuracionHoras()+" horas");

        }
    }


    public void listarEstudiantes() {
        System.out.println("-----Lista de estudiantes:-----");

        for (Estudiante estudiante: estudianteDAO.obtenerTodosLosEstudiantes()) {
            System.out.println("Estudiante: "+estudiante.getNombre());

        }
    }


    public void listarProfesores() {
        System.out.println("-----Lista de profesores:-----");
        for (Profesor profesor : profesorDAO.obtenerTodosLosProfesores()) {
            System.out.println("Profesor: "+profesor.getNombre()+" "+profesor.getCursos()+" "+profesor.getEspecialidad());

    }



}}
