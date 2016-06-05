package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dto.Seguimiento;
import co.com.inversiones_xyz.ss.dto.Usuario;
import co.com.inversiones_xyz.ss.exception.DaoException;
import co.com.inversiones_xyz.ss.exception.ServiceException;
import co.com.inversiones_xyz.ss.service.SeguimientoService;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SeguimientoServiceTest {
	@Autowired
	SeguimientoService seguimientoService;

	
	@Test
	public void testResponderSolicitud() throws DaoException, ServiceException{
		try{
			Seguimiento seguimiento = seguimientoService.responderSolicitud(2, "joanma", "1");
			System.out.println(seguimiento.getId()+" "+seguimiento.getFechaCreacion());
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}		
	}

	@Test
	public void testReasignarSolicitud() throws DaoException, ServiceException{
		try{
			Usuario usuario = seguimientoService.reasignarSolicitud(2, "joanma", "rafagol", "1");
			System.out.println(usuario.getNombres()+usuario.getApellidos());
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}

	@Test
	public void testConsultarResultadoEncuestas() throws DaoException, ServiceException{
		try{
			String resultado = seguimientoService.consultarResultadoEncuentas(1, "joanma", "1");
			System.out.println("Resultado: "+resultado);
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}

	@Test
	public void testConsultarResultadosEncuestas() throws DaoException, ServiceException{
		List<String> resultados = null;
		try{
			resultados = seguimientoService.consultarResultadosEncuentas("joanma", "1");
			for(String resultado :resultados){
				System.out.println("Resultado: "+resultado);
			}
		}catch(DaoException ex){
			fail(ex.getMessage());
		}catch(ServiceException ex){
			fail(ex.getMessage());
		}
	}
	
}
