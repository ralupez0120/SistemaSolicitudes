package co.com.inversiones_xyz.ss.dao;

import java.util.List;

import co.com.inversiones_xyz.ss.dto.Rol;
import co.com.inversiones_xyz.ss.dto.Usuario;
import co.com.inversiones_xyz.ss.exception.DaoException;

/**
 * Interface que define los metodos que va a proveer el dao usuario
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna P�rez
 * 		Joan Manuel Rodr�guez
 * @version 1.0.0
 * 			10/05/2016
 *
 */
public interface UsuarioDAO {
	
	/**
	 * Entrega la informacion de un usuario en el sistema dado nombreUsuario
	 * @param nombreUsuario: nombreUsuario del usuario
	 * @return instancia de los datos del usuario
	 * @throws DaoException cuando ocurre un error en la BD
	 */
	public Usuario obtener(String nombreUsuario)throws DaoException;
	
	/**
	 * Entrega los usuarios activos en el sistema
	 * @return lista de instancias de los datos de todos las sucursales
	 * @throws DaoException cuando ocurre un error en la comunicacion con la BD
	 */
	public List<Usuario> obtenerTodos()throws DaoException;
	
	/**
	 * 
	 * @param rol
	 * @return
	 * @throws DaoException
	 */
	public List<Usuario> obtenerPorRol(Rol rol)throws DaoException;
}