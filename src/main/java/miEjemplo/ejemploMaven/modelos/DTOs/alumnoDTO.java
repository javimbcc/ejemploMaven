package miEjemplo.ejemploMaven.modelos.DTOs;

/**
 * @author menaj AlumnoDTO En este fichero estara nuestro modelo de alumnoDTO
 *         para poder manejar la información
 */
public class alumnoDTO {
	public String id = "";
	public String nombre = "";
	public String apellidos = "";
	public String email = "";

	// Constructor
	public alumnoDTO(String Id, String Nombre, String Apellidos, String Email) {
		this.id = Id;
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.email = Email;
	}
}
