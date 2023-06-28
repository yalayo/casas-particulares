package app.registro.reservaciones.web.bean;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.registro.reservaciones.service.ReservacionService;

public class ReservacionBaseManejado extends ApplicationBaseBean {
	private ReservacionService reservacionService;
	
	public ReservacionBaseManejado() {
		super();
	}

	public ReservacionService getReservacionService() {
		if(reservacionService == null)
			reservacionService = (ReservacionService)getBeanValue("reservacionService");
		
		return reservacionService;
	}
}
