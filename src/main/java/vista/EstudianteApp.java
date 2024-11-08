package vista;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;

public class EstudianteApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlumnoServicio gestor = new AlumnoServicio();

		while (true) {
			System.out.println("\nGestión de Estudiantes");
			System.out.println("----------------------");
			System.out.println("1. Crear Alumno");
			System.out.println("2. Listar Alumnos");
			System.out.println("3. Agregar Materias");
			System.out.println("4. Agregar Notas");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = sc.nextInt();
			sc.nextLine(); // Limpiar buffer

			switch (opcion) {
				case 1:
					// Crear Alumno
					System.out.print("Ingrese RUT: ");
					String rut = sc.nextLine();
					System.out.print("Ingresa Nombre: ");
					String name = sc.nextLine();
					System.out.print("Ingresa Apellido: ");
					String lastName = sc.nextLine();
					System.out.print("Ingresa Dirección: ");
					String direccion = sc.nextLine();
					Estudiante estudiante = new Estudiante(name, rut, lastName, direccion);
					gestor.agregarEstudiante(estudiante);
					System.out.println("Estudiante agregado exitosamente.");
					break;

				case 2:
					// Listar Alumnos
					gestor.listarEstudiantes();
					break;

				case 3:
					// Agregar Materia
					System.out.println("--- Agregar Materia ---");
					System.out.print("Ingresa rut del Alumno: ");
					String rutBusqueda = sc.nextLine();
					Estudiante buscado = gestor.obtenerEstudiante(rutBusqueda);

					if (buscado != null) {
						System.out.println("Estudiante encontrado: " + buscado.getNombre());
						System.out.println("Lista de materias disponibles:");

						MateriaEnum[] materiasDisponibles = MateriaEnum.values();
						for (int i = 0; i < materiasDisponibles.length; i++) {
							System.out.println((i + 1) + ". " + materiasDisponibles[i]);
						}

						System.out.print("Seleccione el número de la materia para agregar: ");
						int seleccion = sc.nextInt();
						sc.nextLine(); // Limpiar buffer

						if (seleccion > 0 && seleccion <= materiasDisponibles.length) {
							MateriaEnum materiaEnum = materiasDisponibles[seleccion - 1];
							Materia nuevaMateria = new Materia(materiaEnum.name(), 0); // Nota predeterminada de 0
							buscado.agregarMateria(nuevaMateria);
							System.out.println("--- ¡Materia agregada! ---");
						} else {
							System.out.println("Selección no válida.");
						}
					} else {
						System.out.println("Estudiante no encontrado.");
					}
					break;

				case 4:
					// Agregar Notas
					System.out.println("--- Agregar Nota ---");
					System.out.print("Ingrese RUT del Alumno: ");
					String rutNota = sc.nextLine();
					Estudiante estudianteNota = gestor.obtenerEstudiante(rutNota);

					if (estudianteNota != null) {
						System.out.println("Alumno encontrado: " + estudianteNota.getNombre());
						if (!estudianteNota.getMaterias().isEmpty()) {
							System.out.println("Alumno tiene las siguientes materias agregadas:");
							for (int i = 0; i < estudianteNota.getMaterias().size(); i++) {
								System.out.println((i + 1) + ". " + estudianteNota.getMaterias().get(i).getNombre());
							}

							System.out.print("Seleccionar materia: ");
							int seleccionMateria = sc.nextInt();
							sc.nextLine(); // Limpiar buffer

							if (seleccionMateria > 0 && seleccionMateria <= estudianteNota.getMaterias().size()) {
								Materia materiaSeleccionada = estudianteNota.getMaterias().get(seleccionMateria - 1);
								System.out.print("Ingresar nota: ");
								double nuevaNota = sc.nextDouble();
								sc.nextLine(); // Limpiar buffer

								materiaSeleccionada.setNota(nuevaNota);
								System.out.println("--- ¡Nota agregada a " + materiaSeleccionada.getNombre() + "! ---");
							} else {
								System.out.println("Selección no válida.");
							}
						} else {
							System.out.println("El alumno no tiene materias agregadas.");
						}
					} else {
						System.out.println("Estudiante no encontrado.");
					}
					break;


				case 5:
					// Exportar Datos
					System.out.println("--- Exportar Datos ---");
					System.out.print("Ingresa la ruta en donde se exportará el archivo promedios.txt: ");
					String ruta = sc.nextLine();

					// Crear el archivo de salida
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/promedios.txt"))) {
						for (Estudiante estudianteExportar : gestor.getEstudiantes()) {
							// Escribir datos del estudiante
							writer.write("Alumno: " + estudianteExportar.getRut() + " - " + estudianteExportar.getNombre());
							writer.newLine();

							for (Materia materia : estudianteExportar.getMaterias()) {
								// Escribir los datos de cada materia y su promedio
								writer.write("Materia: " + materia.getNombre() + " - Promedio: " + materia.getNota());
								writer.newLine();
							}

							writer.newLine(); // Espacio entre estudiantes
						}

						System.out.println("Datos exportados correctamente.");
					} catch (IOException e) {
						System.out.println("Error al exportar los datos: " + e.getMessage());
					}
					break;


				case 6:
					System.out.println("Saliendo...");
					sc.close();
					return;

				default:
					System.out.println("Opción no válida, intente de nuevo.");
			}
		}
	}
}
