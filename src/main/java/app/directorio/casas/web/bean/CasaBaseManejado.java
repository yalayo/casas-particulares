package app.directorio.casas.web.bean;

import app.directorio.casas.service.CasaService;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.registro.reservaciones.service.ReservacionService;

public class CasaBaseManejado extends ApplicationBaseBean {
	//private DatoService datoService;
	//private PreguntaService preguntaService;
	private CasaService casaService;
	private ReservacionService reservacionService;
	
	public CasaBaseManejado() {
		
	}
	
	/*public DatoService getDatoService() {
		if(datoService == null)
			datoService = (DatoService)getBeanValue("datoService");
		
		return datoService;
	}

	public PreguntaService getPreguntaService() {
		if(preguntaService == null)
			preguntaService = (PreguntaService)getBeanValue("preguntaService");
		
		return preguntaService;
	}*/	
	
	public CasaService getCasaService() {
		if(casaService == null)
			casaService = (CasaService)getBeanValue("casaService");
		
		return casaService;
	}
	
	public ReservacionService getReservacionService() {
		if(reservacionService == null)
			reservacionService = (ReservacionService)getBeanValue("reservacionService");
		
		return reservacionService;
	}
}
