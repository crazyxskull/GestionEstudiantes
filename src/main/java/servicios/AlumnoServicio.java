package servicios;

import modelo.Estudiante;
import java.util.List;
import java.util.ArrayList;

public class AlumnoServicio {

	private List<Estudiante> estudiantes;

	public AlumnoServicio() {
		estudiantes = new ArrayList<>();
	}

	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

	public Estudiante obtenerEstudiante(String rut) {
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equals(rut)) {
				return estudiante;
			}
		}
		return null; // No se encuentra el estudiante
	}

	public void listarEstudiantes() {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
	}

	// Método para obtener la lista de estudiantes
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
}
