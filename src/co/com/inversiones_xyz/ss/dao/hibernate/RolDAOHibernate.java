package co.com.inversiones_xyz.ss.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.com.inversiones_xyz.ss.dao.RolDAO;
import co.com.inversiones_xyz.ss.dto.Rol;
import co.com.inversiones_xyz.ss.exception.DaoException;


public class RolDAOHibernate extends HibernateDaoSupport implements RolDAO{
	/**
	 * Permite obtener un rol dado el codigo
	 */
	public Rol obtener(String codigo) throws DaoException{
		Rol rol = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();		
			rol = (Rol) session.get(Rol.class, codigo);
		}catch(HibernateException ex){
			throw new DaoException(ex);
		}
		return rol;
	}
}
