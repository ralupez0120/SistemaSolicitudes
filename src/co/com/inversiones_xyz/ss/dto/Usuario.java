package co.com.inversiones_xyz.ss.dto;

/**
 * Clase dto que guarda informaci�n necesaria de los usuarios para que puedan
 * iniciar sesi�n en el sistema. S�lamente ser�n usuarios del sistema el gerente de
 * cuentas y toda persona que �l asigne para atender una solicitud.
 * 
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna P�rez
 * 		Joan Manuel Rodr�guez
 * @version 1.0.0
 * 			08/05/2016
 */

public class Usuario {
	
	private String nombres;	//Nombres del usuario	
	private String apellidos; //Apellidos del usuario	
	private String nombreUsuario; //Nombre de usuario o login para iniciar sesi�n en el sistema
	private String password;  //Contrase�a para iniciar sesi�n en el sistema	
	private String correo;	//Correo electr�nico del usuario		
	private Rol rol; //Rol que desempe�a el usuario en el sistema	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
