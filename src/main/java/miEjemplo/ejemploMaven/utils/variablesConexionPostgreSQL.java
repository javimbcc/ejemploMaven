package miEjemplo.ejemploMaven.utils;
/**
 * @author menaj
 * En este fichero estaran las variables de conexión de PostgreSQL
 */
public class variablesConexionPostgreSQL {
	// Variables de conexion a postgreSQL
	static final String USER = "postgres";
	static final String PASS = "root";
	static final String PORT = "5432";
	static final String HOST = "localhost";
	static final String DB = "ejemplo1";

	// Getter para recoger la información
	public static String getUser() {
		return USER;
	}

	public static String getPass() {
		return PASS;
	}

	public static String getPort() {
		return PORT;
	}

	public static String getHost() {
		return HOST;
	}

	public static String getDb() {
		return DB;
	}
}
