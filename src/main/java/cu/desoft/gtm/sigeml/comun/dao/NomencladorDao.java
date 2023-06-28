package cu.desoft.gtm.sigeml.comun.dao;

import java.util.List;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.hibernate.dao.ApplicationDao;

public interface NomencladorDao extends ApplicationDao {
	public List<Nomenclador> obtenerPorClave(String clave);
	public List<Nomenclador> obtenerPadres();
	public List<Nomenclador> listarNomencladores();
}
