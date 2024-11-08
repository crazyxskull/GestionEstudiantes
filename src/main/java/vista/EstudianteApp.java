package vista;

import java.util.Scanner;

import modelo.Estudiante;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;

public class EstudianteApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlumnoServicio gestor = new AlumnoServicio();

		while(true) {
			System.out.println("Gestion de Estudiantes");
			System.out.println("----------------------");
			System.out.println("1. Crear Alumno");
			System.out.println("2. Listar Alumnos");
			System.out.println("3. Agregar Materias");
			System.out.println("4. Agregar Notas");
			System.out.println("5. Salir");
			System.out.println("6. Exportar Datos ");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				System.out.println("Ingrese RUT: ");
				String rut = sc.nextLine();
				System.out.println("Ingresa Nombre: ");
				String name = sc.nextLine();
				System.out.println("Ingresa Apellido: ");
				String lastName = sc.nextLine();
				System.out.println("Ingresa Direccion: ");
				String direccion = sc.nextLine();
				Estudiante estudiante = new Estudiante(rut, name,lastName, direccion);
				gestor.agregarEstudiante(estudiante);
				System.out.println("Estudiado agregado exitosamente.");
				break;
			case 2:

				gestor.listarEstudiantes();
				break;
			case 3:
				System.out.println("--- Agregar Materia ---");
				System.out.println("Ingresa rut del Alumno: ");
				String id = sc.nextLine();
				Estudiante buscado = gestor.obtenerEstudiante(id);
				if(buscado != null) {
					// Usar el enum para ingresar las notas
					for (MateriaEnum materiaEnum : MateriaEnum.values()) {
						System.out.println(materiaEnum);
						double nota = sc.nextDouble();
					}
				}else {
					System.out.println("Estudiante No Encontrado");
				}
				break;
			case 4:
				break;
			case 5:
				System.out.println("Saliendo..");
				sc.close();
				return;
			case 6:

			}
		}

	}

}
