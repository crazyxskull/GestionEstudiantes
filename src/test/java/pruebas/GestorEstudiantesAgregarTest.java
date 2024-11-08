package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Estudiante;
import servicios.AlumnoServicio;

public class GestorEstudiantesAgregarTest {

	@Test
	@DisplayName("Prueba agregar estudiante")
	public void testAgregarEstudiante() {
		AlumnoServicio gestor = new AlumnoServicio();

		Estudiante est1 = new Estudiante("Erick", "28","Erick", "28");
		
		gestor.agregarEstudiante(est1);
		Estudiante e = gestor.obtenerEstudiante("28"); 
		assertEquals("28", e.getRut());
	}
}
