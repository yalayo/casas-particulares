package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import cu.desoft.gtm.sigeml.administracion.seguridad.facade.SeguridadFacade;
import cu.desoft.gtm.sigeml.comun.service.NomencladorService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class SeguridadBaseManejado extends BaseBean {
	private SeguridadFacade seguridadFacade;
	private NomencladorService nomencladorService;
	
	public SeguridadBaseManejado() {
		super();
	}

	public SeguridadFacade getSeguridadFacade() {
		if(seguridadFacade == null)
			seguridadFacade = (SeguridadFacade)getBeanValue("seguridadFacade");
		
		return seguridadFacade;
	}

	public NomencladorService geNnomencladorService() {
		if(nomencladorService == null) 
			nomencladorService = (NomencladorService)getBeanValue("nomencladorService");
		
		return nomencladorService;
	}
}
