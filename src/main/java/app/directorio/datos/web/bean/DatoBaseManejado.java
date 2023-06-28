package app.directorio.datos.web.bean;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.configuracion.service.PreguntaService;
import app.directorio.datos.service.DatoService;

public class DatoBaseManejado extends ApplicationBaseBean {
	private DatoService datoService;
	private PreguntaService preguntaService;
	
	public DatoBaseManejado() {
		
	}
	
	public DatoService getDatoService() {
		if(datoService == null)
			datoService = (DatoService)getBeanValue("datoService");
		
		return datoService;
	}

	public PreguntaService getPreguntaService() {
		if(preguntaService == null)
			preguntaService = (PreguntaService)getBeanValue("preguntaService");
		
		return preguntaService;
	}	
}
