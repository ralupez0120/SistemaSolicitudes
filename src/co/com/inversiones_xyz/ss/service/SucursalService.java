package co.com.inversiones_xyz.ss.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dao.SucursalDAO;
import co.com.inversiones_xyz.ss.dto.Sucursal;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;

/**
 * Clase que contiene la logica de negocio para obtener las sucursales registradas en el sistema
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			3/06/2016
 *
 */

@Transactional
public class SucursalService {
	private SucursalDAO sucursalDAO;
	
	/**
	 * 
	 * @return la lista de las sucursales que existen en el sistema
	 * @throws DaoException cuando ocurre un error instanciando las sucursales en el sistema
	 * @throws ServiceException
	 */
	public List<Sucursal> consultarSucursales() throws DaoException, ServiceException{
		List<Sucursal> sucursales = sucursalDAO.obtener();
		return sucursales;
	}

	public SucursalDAO getSucursalDAO() {
		return sucursalDAO;
	}

	public void setSucursalDAO(SucursalDAO sucursalDAO) {
		this.sucursalDAO = sucursalDAO;
	}
	
	
}
