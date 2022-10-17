package miEjemplo.ejemploMaven;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import miEjemplo.ejemploMaven.modelos.DTOs.alumnoDTO;
import miEjemplo.ejemploMaven.modelos.conexiones.conexionPostgreSQL;
import miEjemplo.ejemploMaven.modelos.consultas.consultasPostgreSQL;
import miEjemplo.ejemploMaven.utils.variablesConexionPostgreSQL;

/**
 * @author menaj Controlador de la Aplicación En este apartado estara incluido
 *         el controllador de la aplicación
 */
public class App {
	public static void main(String[] args) {
		// Instanciamos los datos de conexion de utils y los desestructuramos
		conexionPostgreSQL conexion = new conexionPostgreSQL();

		// Instanciamos variablesConexionPostgreSQL para poder recoger los credenciales
		// de inicio de sesion
		variablesConexionPostgreSQL vc = new variablesConexionPostgreSQL();

		// Instanciamos las listas
		List<alumnoDTO> listAlumnos = new ArrayList<alumnoDTO>();

		// Hacemos su desestructuracion
		final String HOST = vc.getHost();
		final String PORT = vc.getPort();
		final String DB = vc.getDb();
		final String USER = vc.getUser();
		final String PASS = vc.getPass();

		// Hacemos la conexion
		Connection cn = conexion.añadirConexionPostgreSql(USER, PASS, PORT, HOST, DB);

		// Hacemos el insert para ver los datos por pantalla
		consultasPostgreSQL.insertarAlumnos(cn);
		// Una vez hecha la conexión hacemos la consulta
		consultasPostgreSQL.listarAlumnos(cn);

		// metemos los valores en la lista
		listAlumnos = consultasPostgreSQL.listarAlumnos(cn);

		// Imprimimos por pantalla

		for (int i = 0; i < listAlumnos.size(); i++) {
			System.out.println("id: " + " " + listAlumnos.get(i).id + " || " + "nombre: " + " "
					+ listAlumnos.get(i).nombre + " || " + "apellidos: " + " " + listAlumnos.get(i).apellidos + " || "
					+ "email: " + " " + listAlumnos.get(i).email);
		}
		//Hacemos el delete
		consultasPostgreSQL.eliminarAlumnos(cn);
		
		//volvemos a imprimir por pantalla para ver que efectivamente se ha eliminado el id=8 que es el que buscamos eliminar
		System.out.println("Tabla de alumnos con el id=8 eliminado");
		for (int i = 0; i < listAlumnos.size(); i++) {
			System.out.println("id: " + " " + listAlumnos.get(i).id + " || " + "nombre: " + " "
					+ listAlumnos.get(i).nombre + " || " + "apellidos: " + " " + listAlumnos.get(i).apellidos + " || "
					+ "email: " + " " + listAlumnos.get(i).email);
		}
		
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
