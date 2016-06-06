package co.com.inversiones_xyz.ss.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dao.ProductoDAO;
import co.com.inversiones_xyz.ss.dto.Producto;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;


/**
 * Clase que contiene la logica de negocio para obtener los productos registrados en el sistema
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			3/06/2016
 *
 */
@Transactional
public class ProductoService {
	private ProductoDAO productoDAO;
	
	/**
	 * 
	 * @return la lista de los productos registrado en el sistema
	 * @throws DaoException cuando ocurre un error instanciando los productos en el sistema
	 * @throws ServiceException
	 */
	public List<Producto> consultarProductos() throws DaoException, ServiceException{
		List<Producto> productos = productoDAO.obtener();
		return productos;
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}
	
}
