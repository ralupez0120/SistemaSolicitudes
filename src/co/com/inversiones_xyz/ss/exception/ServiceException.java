package co.com.inversiones_xyz.ss.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * Clase para administrar las excepciones en los servicios durante la ejecucion del sistema
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			12/05/2016
 *
 */
public class ServiceException extends Exception {
	private final static Logger log = Logger.getLogger(Log4jException.class);
	public ServiceException() {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}


	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

	public ServiceException(String arg0) {
		super(arg0);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

	public ServiceException(Throwable arg0) {
		super(arg0);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Un info");
	}

}
