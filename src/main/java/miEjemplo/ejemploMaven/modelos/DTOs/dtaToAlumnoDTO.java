package miEjemplo.ejemploMaven.modelos.DTOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dtaToAlumnoDTO {
	public static List<alumnoDTO> ReaderAListAlumnoDTO(ResultSet resultadoConsulta) {
		// Metemos los datos en la lista alumnoDTo
		List<alumnoDTO> listAlumnos = new ArrayList<alumnoDTO>();
		try {
			while (resultadoConsulta.next()) {
				listAlumnos
						.add(new alumnoDTO((resultadoConsulta.getString("id")), resultadoConsulta.getString("nombre"),
								resultadoConsulta.getString("apellidos"), resultadoConsulta.getString("email")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAlumnos;
	}
}
