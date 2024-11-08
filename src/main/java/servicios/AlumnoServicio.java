package servicios;

import java.util.HashMap;
import java.util.Map;

import modelo.Estudiante;
import modelo.Materia;

public class AlumnoServicio {

	private Map<String, Estudiante> estudiantes;

	public AlumnoServicio() {
		estudiantes = new HashMap<>();
	}

	public void agregarEstudiante(Estudiante student) {
		estudiantes.put(student.getRut(), student);
	}

	public Estudiante obtenerEstudiante(String id) {
		return estudiantes.get(id);
	}

	public void actualizarEstudiante(String id, String newNombre){
		Estudiante estudiante = estudiantes.get(id);
		if(estudiante != null) {
			estudiante.setNombre(newNombre);
			System.out.println("Estudiante actualizado.");
		}else {
			System.out.println("Estudiante No encontrado.");
		}
	}


	public void listarEstudiantes() {
		if(estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes registrados.");
		}else {
			for(Estudiante e : estudiantes.values()) {
				System.out.println(e);
			}
		}
	}
	public void agregarMateria(String rutAlumno,Materia currentMate) {


	}
}
