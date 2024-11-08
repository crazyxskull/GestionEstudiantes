package pruebas;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	GestorEstudiantesAgregarTest.class,
	AlumnoServicioObtenerTest.class
})
public class AlumnoServicioSuiteTest {

}
