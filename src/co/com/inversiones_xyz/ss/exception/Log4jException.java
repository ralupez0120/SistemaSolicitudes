package co.com.inversiones_xyz.ss.exception;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
/**
 * Clase para llevar registros de los errores en un archivo
 * @author 
 * 		Juan Carlos Estrada
 * 		Rafael Luna Pérez
 * 		Joan Manuel Rodríguez
 * @version 1.0.0
 * 			25/05/2016
 *
 */
public class Log4jException {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("Adminitrador de logger");
		log.info("un info");
	}
}
