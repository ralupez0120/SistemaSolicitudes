package co.com.inversiones_xyz.ss.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dao.RolDAO;
import co.com.inversiones_xyz.ss.dao.UsuarioDAO;
import co.com.inversiones_xyz.ss.dto.Rol;
import co.com.inversiones_xyz.ss.dto.Usuario;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;
import co.com.inversiones_xyz.ss.util.encode.Cifrar;
import co.com.inversiones_xyz.ss.util.validations.Validaciones;



/**
 * Clase que contiene la logica de negocio para validar los usuarios
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna P�rez
 * 		Joan Manuel Rodr�guez
 * @version 1.0.0
 * 			3/06/2016
 *
 */
@Transactional
public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;
	
	/**
	 * M�TODO AUTENTICAR USUARIO
	 * Valida que el usuario este autenticado
	 * 
	 * @param nombreUsuario
	 *            nombre del usuario que desea autentica
	 * @param clave
	 *            password del usuario que desea autenticar
	 * @return verdadero si est� autenticado o falso de lo contrario
	 * @throws DaoException
	 *             cuando ocurre un error instanciando el usuario en la BD
	 * @throws ServiceException
	 *             cuando ingresan un parametro no valido
	 */
	public Boolean autenticarUsuario(String nombreUsuario, String clave) throws DaoException, ServiceException {

		Cifrar cifrar = new Cifrar();

		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new ServiceException("El nombre de usuario no puede ser nula, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(clave)) {
			throw new ServiceException("La clave del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}

		Usuario usuario = usuarioDAO.obtener(nombreUsuario);
		if (usuario == null) {
			throw new ServiceException("Usuario o contrase�a no v�lidos");
		}

		if (!cifrar.encrypt(clave).equals(usuario.getPassword())) {
			throw new ServiceException("Usuario o contrase�a no v�lidos");
		}
		return Boolean.TRUE;
	}
	
	/**
	 * M�TODO VALIDAR QUE USUARIO ES GERENTE DE CUENTAS
	 * 
	 * Valida que el usuario ingresado como par�metro sea el 
	 * gerente de cuentas corporativas.
	 * Tener en cuenta para este m�todo, que se contar� con el hecho de que 
	 * el c�digo del rol para el gerente de cuentas ser� 1 en la tabla rol de la base 
	 * de datos. En caso de que este c�digo sea cambiado en la base de datos, 
	 * poner ese nuevo valor en la variable codigoRolGerente.
	 * 
	 * @param nombreUsuario
	 *            nombre del usuario que desea realizar alguna acci�n en el sistema
	 * @return verdadero si es el gerente de cuentas o falso de lo contrario
	 * @throws DaoException
	 *             cuando ocurre un error consultando el usuario en la BD
	 * @throws ServiceException
	 *             cuando ingresan un par�metro no valido
	 *             cuando no existe un usuario con ese userName
	 */
	public boolean EsGerenteCuentas(String nomUsuario)throws DaoException, ServiceException{
		
		if (Validaciones.isTextoVacio(nomUsuario)) {
			throw new ServiceException("El nombre de usuario no puede ser nulo, ni una cadena de caracteres vac�a");
		}
		String codigoRolGerente="1";
		Usuario actualUsuario=usuarioDAO.obtener(nomUsuario);
		if(actualUsuario!=null && actualUsuario.getRol().getCodigo().equals(codigoRolGerente)){
			return true;
		}
		return false;
	}
	
	/**
	 * M�TODO OBTENER TODOS LOS USUARIOS
	 * Retorna una lista con todos los usuarios activos en el sistema
	 * 
	 * @return lista con todos los usuarios 
	 * 
	 * @throws DaoException
	 *             cuando ocurre un error consultando los usuarios en la BD
	 */
	public List<Usuario> UsuariosActivos()throws DaoException{
		return usuarioDAO.obtenerTodos();	
	}
	
	/**
	 * M�TODO OBTENER GERENTE DE CUENTAS
	 * Obtiene el usuario correspondiente al gerente de cuentas. Este servicio 
	 * funciona teniendo en cuenta que el gerente de cuentas tiene asignado
	 * el codigoRol=1; en caso de que este c�digo sea diferente en la base de datos,
	 * cambiarlo en la variable codigoRolGerente.
	 * Este m�todo ser� utilizado �nicamente en la generaci�n de solicitudes; puesto 
	 * que cada nueva solicitud es siempre asignada autom�ticamente al gerente de
	 * cuentas.
	 * 
	 * @return gerente de cuentas 
	 * 
	 * @throws DaoException
	 *             cuando ocurre un error consultando el rol o usuario en la BD
	 * @throws ServiceException
	 *             cuando no hay a�n creado un usuario para el gerente de cuentas
	 *             en el sistema
	 */
	public Usuario ObtieneGerenteCuentas()throws DaoException,ServiceException{
		String codigoRolGerente="1";
		Rol rolGerente=rolDAO.obtener(codigoRolGerente);
		Usuario gerenteCuentas=usuarioDAO.obtenerPorRol(rolGerente).get(0);
		if(rolGerente==null || gerenteCuentas==null){
			throw new ServiceException("A�n no hay una cuenta de usuario creada en el"
					+ "sistema para el gerente de cuentas");
		}else{
			return gerenteCuentas;
		}
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}
	
}
