package miEjemplo.ejemploMaven.modelos.consultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miEjemplo.ejemploMaven.modelos.DTOs.alumnoDTO;
import miEjemplo.ejemploMaven.modelos.DTOs.dtaToAlumnoDTO;

/**
 * @author menaj Consultas En este fichero estaran nuestras consultas a nuestra
 *         base de datos
 */
public class consultasPostgreSQL {
	public static List<alumnoDTO> listarAlumnos(Connection conexion) {
		// Declaramos la lista
		List<alumnoDTO> listAlumnos = new ArrayList<alumnoDTO>();
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS LA CONSULTA");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"ejercicioCCasa\".\"Alumnos\"");

				// Lo metemos en la lista

				listAlumnos = dtaToAlumnoDTO.ReaderAListAlumnoDTO(resultadoConsulta);

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL: " + e);

			}
		}
		return listAlumnos;
	}

	// Insert alumno
	public static void insertarAlumnos(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El INSERT");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL
						.executeQuery("INSERT INTO \"ejercicioCCasa\".\"Alumnos\" (nombre,apellidos,email)"
								+ "VALUES('Insert','De Ejemplo','insert@gmail.com')");

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL (insert): " + e);

			}
		}
	}

	// Delete alumno

	public static void eliminarAlumnos(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El DELETE");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL
						.executeQuery("DELETE FROM \"ejercicioCCasa\".\"Alumnos\" WHERE id='8'");

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL (DELETE): " + e);

			}
		}
	}

	// Update alumno
	public static void cambiarDatosAlumno(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS El UPDATE");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL
						.executeQuery("UPDATE \"ejercicioCCasa\".\"Alumnos\" SET nombre='Antonio', apellidos='Sumerio2', email='cigalaupdate@update.com' WHERE id=6 ");

			} catch (SQLException e) {
				System.out.println("Error generando la declaracionSQL (UPDATE): " + e);

			}
		}
	}
}
