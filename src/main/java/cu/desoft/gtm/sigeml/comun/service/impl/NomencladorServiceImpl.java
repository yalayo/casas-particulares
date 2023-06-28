package cu.desoft.gtm.sigeml.comun.service.impl;

import java.util.List;

import cu.desoft.gtm.sigeml.comun.dao.NomencladorDao;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.comun.service.NomencladorService;

public class NomencladorServiceImpl implements NomencladorService {
	private NomencladorDao nomencladorDao;
	
	public NomencladorServiceImpl() {
		
	}
	
	public NomencladorDao getNomencladorDao() {
		return nomencladorDao;
	}

	public void setNomencladorDao(NomencladorDao nomencladorDao) {
		this.nomencladorDao = nomencladorDao;
	}

	public void salvar(Nomenclador nomenclador){
		nomencladorDao.salvar(nomenclador);
	}
	
	public void modificar(Nomenclador nomenclador){
		nomencladorDao.actualizar(nomenclador);
	}
	
	public void deshabilitar(Nomenclador nomenclador){
		nomencladorDao.eliminar(nomenclador);
	}
	
	public List<Nomenclador> obtenerNomenclador(String clave) {
		return nomencladorDao.obtenerPorClave(clave);
	}
	
	public List<Nomenclador> obtenerPadres(){
		return nomencladorDao.obtenerPadres();
	}

	public List<Nomenclador> listarNomencladores() {
		return nomencladorDao.listarNomencladores();
	}

}
