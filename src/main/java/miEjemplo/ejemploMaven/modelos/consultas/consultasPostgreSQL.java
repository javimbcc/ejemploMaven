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
				resultadoConsulta = declaracionSQL
						.executeQuery("SELECT * FROM \"dlk_operacional_productos\".\"opr_cat_productos\"");

				// Lo metemos en la lista

				listAlumnos = dtaToAlumnoDTO.ReaderAListAlumnoDTO(resultadoConsulta);

			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL: " + e);

			}
		}
		return listAlumnos;
	}
}
