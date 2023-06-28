package app.comun.dao.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import app.comun.dao.ApplicationDao;

public class ApplicationDaoHib implements ApplicationDao {
	private HibernateTemplate hibernateTemplate;
	
	public ApplicationDaoHib() {
		super();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void salvar(Object object) {
		hibernateTemplate.save(object);
	}
	
	public void actualizar(Object object) {
		hibernateTemplate.update(object);
	}
	
	public void eliminar(Object object) throws Exception {
		try {
			hibernateTemplate.delete(object);
		}
		
		catch(DataIntegrityViolationException ex) {
			if(ex.getCause() instanceof ConstraintViolationException)
				throw new Exception("No se puede eliminar porque esta relacionado con otro elemento.");
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Object obtenerPorId(Integer id, Class<?> clazz) {
		return hibernateTemplate.get(clazz, id);
	}
	
	public List<?> obtenerTodos(Class<?> clazz) {
		return hibernateTemplate.loadAll(clazz);
	}
}
