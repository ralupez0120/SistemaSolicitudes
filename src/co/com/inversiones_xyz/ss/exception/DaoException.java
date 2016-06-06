package co.com.inversiones_xyz.ss.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * Clase para administrar los errores ocurridos en la comunicacion con la BD
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			12/05/2016
 *
 */
public class DaoException extends Exception {
	private final static Logger log = Logger.getLogger(Log4jException.class);
	public DaoException() {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

	public DaoException(String arg0) {
		super(arg0);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

	public DaoException(Throwable arg0) {
		super(arg0);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

}
