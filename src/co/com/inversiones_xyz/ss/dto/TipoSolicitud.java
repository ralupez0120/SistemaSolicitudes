package co.com.inversiones_xyz.ss.dto;
/**
 * Clase dto que guarda el tipo de solicitud que puede ser generada por un usuario
 * a trav�s del sistema.
 * Los principales tipos de solicitudes son:
 * 	- Petici�n
 * 	- Queja
 * 	- Reclamo
 * 	- Sugerencia  
 * 
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna P�rez
 * 		Joan Manuel Rodr�guez
 * @version 1.0.0
 * 			08/05/2016
 * 
 */
public class TipoSolicitud {
	
	private Integer codigo; //Identificador univoco de un tipo de solicitud
	private String nombre; //Nombre del tipo de solicitud (petici�n, queja, reclamo, etc.)
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
