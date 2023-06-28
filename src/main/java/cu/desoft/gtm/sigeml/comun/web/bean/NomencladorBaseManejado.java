package cu.desoft.gtm.sigeml.comun.web.bean;
import cu.desoft.gtm.sigeml.comun.service.NomencladorService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class NomencladorBaseManejado extends BaseBean {
	private NomencladorService nomencladorService;
	
	public NomencladorBaseManejado() {
		super();
	}
	
	public NomencladorService getNomencladorService() {
		if(nomencladorService == null) 
			nomencladorService = (NomencladorService)getBeanValue("nomencladorService");
		
		return nomencladorService;
	}
}
