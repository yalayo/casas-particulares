package app.directorio.configuracion.web.bean;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.configuracion.service.PreguntaService;
import app.directorio.datos.service.DatoService;

public class ConfiguracionBaseManejado extends ApplicationBaseBean {
	private DatoService datoService;
	private PreguntaService preguntaService;
	
	public ConfiguracionBaseManejado() {
		
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
