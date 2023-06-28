package cu.desoft.gtm.sigeml.comun.dao.test;

import java.util.ArrayList;
import java.util.List;

import cu.desoft.gtm.sigeml.comun.dao.NomencladorDao;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.test.dao.ApplicationDaoTestCase;

public class NomencladorDaoTestCase extends ApplicationDaoTestCase {
	private NomencladorDao nomencladorDao;
	
	public NomencladorDaoTestCase() {
		List<String> lista = new ArrayList<String>();
		lista.add("classpath:cu/sib/fcba/comun/config/test/applicationContext-dao.xml");
		
		configurar(lista);
		
		nomencladorDao = (NomencladorDao)getApplicationContext().getBean("nomencladorDao");
	}
	
	public void estSalvar() {
		Nomenclador padre = new Nomenclador();
		padre.setId(1);
		
		Nomenclador nomenclador = new Nomenclador();
		nomenclador.setValue("Deshabilitado");
		nomenclador.setDescripcion("La entidad se encuentra deshabilitada.");
		nomenclador.setPadre(padre);
		nomenclador.setTipoNomenclador("Administracion");
		nomenclador.setKeyWord("e1");
		
		nomencladorDao.salvar(nomenclador);
		
		Nomenclador temp = (Nomenclador)nomencladorDao.obtenerPorId(nomenclador.getId(), Nomenclador.class);
		
		assertNotNull(temp);
	}
	
	public void estModificar(){
		fail("No implementado");
	}
	
	public void estDeshabilitar(){
		fail("No implementado");
	} 
	
	public void testObtenerPorClave(){
		List<Nomenclador> lista = nomencladorDao.listarNomencladores();
		
		//assertEquals(lista.size(), 2);
		for(int i = 0; i < lista.size(); i ++) {
			System.out.println(lista.get(i));
		}
	}
}
