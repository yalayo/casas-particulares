package cu.desoft.gtm.sigeml.comun.service;

import java.util.List;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public interface NomencladorService {
	public void salvar(Nomenclador nomenclador);
	public void modificar(Nomenclador nomenclador);
	public void deshabilitar(Nomenclador nomenclador);
	public List<Nomenclador> obtenerPadres();
	public List<Nomenclador> obtenerNomenclador(String clave);
	public List<Nomenclador> listarNomencladores();
}
