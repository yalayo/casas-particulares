package cu.desoft.gtm.sigeml.comun.dao.impl;

import java.util.List;

import cu.desoft.gtm.sigeml.comun.dao.NomencladorDao;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.hibernate.dao.impl.ApplicationDaoImpl;

public class NomencladorDaoImpl extends ApplicationDaoImpl implements
		NomencladorDao {

	@SuppressWarnings("unchecked")
	public List<Nomenclador> obtenerPorClave(String clave) {
		return getHibernateTemplate().find("from Nomenclador nomenclador where nomenclador.keyWord ='" + clave + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Nomenclador> obtenerPadres() {
		return getHibernateTemplate().find("from Nomenclador nomenclador where nomenclador.padre = null");
	}

	public List<Nomenclador> listarNomencladores() {
		//return getHibernateTemplate().find("from Nomenclador nomenclador where nomenclador.padre != null");
		return getHibernateTemplate().find("from Nomenclador nomenclador");
	}
}
