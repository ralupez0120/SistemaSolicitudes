package co.com.inversiones_xyz.ss.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dao.TipoSolicitudDAO;
import co.com.inversiones_xyz.ss.dto.TipoSolicitud;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;

/**
 * Clase que contiene la logica de negocio para consultar los tipos de solicitud definidos en el sistema
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			3/06/2016
 *
 */
@Transactional
public class TipoSolicitudService {
	private TipoSolicitudDAO tipoDAO;
	
	/**
	 * 
	 * @return lita de los tipos de solicitud definidos en el sistema
	 * @throws DaoException cuando ocurre un error obteniendo los tipos de solicitudes
	 * @throws ServiceException
	 */
	public List<TipoSolicitud> consultarTipos() throws DaoException, ServiceException{
		List<TipoSolicitud> tipos = tipoDAO.obtener();
		return tipos;
	}

	public TipoSolicitudDAO getTipoDAO() {
		return tipoDAO;
	}

	public void setTipoDAO(TipoSolicitudDAO tipoDAO) {
		this.tipoDAO = tipoDAO;
	}

	
}
