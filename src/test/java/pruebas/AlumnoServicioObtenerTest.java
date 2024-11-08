package pruebas;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Estudiante;
import servicios.AlumnoServicio;

public class AlumnoServicioObtenerTest {

	@Test
	@DisplayName("Prueba obtener estudiante")
	public void testObtenerEstudiante() {
		AlumnoServicio gestor = new AlumnoServicio();
		
		Estudiante est1 = new Estudiante("Erick", "28","Erick", "28");
		
		gestor.agregarEstudiante(est1);
		
		Estudiante todos = gestor.obtenerEstudiante("28");
		
		assertNotNull(todos);
	}
}
