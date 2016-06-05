package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dto.Solicitud;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;
import co.com.inversiones_xyz.ss.service.SolicitudService;


@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(defaultRollback=false)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {
	@Autowired
	SolicitudService solicitudService;
	
	//@Test
	@Rollback(value=false)
	public void testGenerarSolicitud() {
		try{
			Solicitud solicitud = solicitudService.generarSolicitud(3,
					"Julano", "Mengano Correa", "julano@gmail.com", "4427896", 
					"3126171619", "Muy mal servicio", "B01", 2, 4, 3);
			System.out.println(solicitud.getRadicado()+""+solicitud.getDescripcion()
			+solicitud.getSeguimiento().getResponsable().getRol().getNombre());
		}catch(DaoException ex){
			ex.printStackTrace();
			fail(ex.getMessage());
		}catch(ServiceException ex){
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}

	//@Test
	public void testConsultarSolicitudesPorUsuario() throws DaoException, ServiceException{
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = solicitudService.consultarSolicitudes("joanma");
			for(Solicitud solicitud: solicitudes){
				System.out.println(solicitud.getNombres()+solicitud.getApellidos());
			}
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}	
	
	//@Test
	public void testConsularSolicitud()throws DaoException, ServiceException{
		Solicitud solicitud = null;
		try{
			solicitud = solicitudService.consultarSolicitud(123456, "aperez", "AB102");
			if(null!=solicitud)
				System.out.println(solicitud.getNombres()+solicitud.getApellidos());
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}

	@Test
	public void testSeguirSolicitudes() throws DaoException, ServiceException{
		try{
			List<Solicitud> solicitudes = solicitudService.seguirSolicitudes("joanma");
			for(Solicitud solicitud : solicitudes){
				System.out.println(solicitud.getRadicado()+solicitud.getNombres());
			}
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}
}