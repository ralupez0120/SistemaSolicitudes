package co.com.inversiones_xyz.ss.dto;

/**
 * Clase dto que guarda la informaci�n correspondiente a una sucursal de la 
 * empresa en donde un cliente haya adquirido un producto y que haya asociado con una
 * petici�n, queja, reclamo, o sugerencia. 
 * 
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna P�rez
 * 		Joan Manuel Rodr�guez
 * @version 1.0.0
 * 			08/05/2016
 *
 */

public class Sucursal {
	private String codigo;	//Identificador de la sucursal	
	private String nombre;	//Nombre de la sucursal	
	private String direccion; //Direcci�n de la sucursal	
	private String ciudad;	//Ciudad en la que se encuentra ubicada la sucursal
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
