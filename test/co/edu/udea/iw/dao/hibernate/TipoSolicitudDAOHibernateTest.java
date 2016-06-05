package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.inversiones_xyz.ss.dao.TipoSolicitudDAO;
import co.com.inversiones_xyz.ss.dto.TipoSolicitud;
import co.com.inversiones_xyz.ss.exception.DaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:configuracion.xml")
@Transactional
public class TipoSolicitudDAOHibernateTest {
	@Autowired
	TipoSolicitudDAO tipoDao;

	@Test
	public void tesObtener() throws DaoException {
		TipoSolicitud tipo = null;
		try {
			tipo = tipoDao.obtener(1004);
			if (null != tipo)
				System.out.println(tipo.getNombre());
		} catch (DaoException ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testObtenerTodos()throws DaoException{
		List<TipoSolicitud> tipos = null;
		try{
			tipos = tipoDao.obtener();
			for(TipoSolicitud tipo: tipos){
				System.out.println(tipo.getCodigo()+tipo.getNombre());
			}
		}catch(DaoException ex){
			fail(ex.getMessage());
		}
	}
}
