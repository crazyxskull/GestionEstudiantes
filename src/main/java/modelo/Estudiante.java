package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	private String rut;
	private String nombre;
	private String apellido;
	private String direccion;
	private List<Materia> materias;

	public Estudiante(String nombre, String rut, String apellido, String direccion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
        this.apellido = apellido;
		this.direccion = direccion;
        this.materias = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellido() {return apellido;
	}

	public void setApellido(String apellido) {this.apellido = apellido;
	}

	public String getDireccion() {return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}

	@Override
	public String toString() {

		return "Alumno \nNombre: " + nombre + "\nRUT :" + rut + "\nMaterias " +"\n" +materias.toString() ;
	}


}
