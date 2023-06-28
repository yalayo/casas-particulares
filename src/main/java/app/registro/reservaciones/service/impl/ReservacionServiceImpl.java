package app.registro.reservaciones.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.comun.service.impl.ApplicationServiceImpl;
import app.directorio.casas.domain.Casa;
import app.registro.reservaciones.dao.ReservacionDao;
import app.registro.reservaciones.domain.Reservacion;
import app.registro.reservaciones.service.ReservacionService;

public class ReservacionServiceImpl extends ApplicationServiceImpl implements ReservacionService {
	private ReservacionDao reservacionDao;
	
	public ReservacionServiceImpl() {
		
	}
	
	public void setReservacionDao(ReservacionDao reservacionDao) {
		this.reservacionDao = reservacionDao;
	}

	public List<Reservacion> consultar(String nombre, String numero, String numeroReservaCubanacan, String numeroReservaCubatur) {
		List<Reservacion> reservaciones = (List<Reservacion>)obtenerTodos(Reservacion.class);
    	List<Reservacion> lista = new ArrayList<Reservacion>();
    	
    	for(int i = 0; i < reservaciones.size(); i ++) {
    		Reservacion r = reservaciones.get(i);
    		boolean adicionar = false;
    		
    		if(!nombre.isEmpty()) {
    			if(r.getNombre() != null) {
	    			if(r.getNombre().startsWith(nombre)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		if(!numero.isEmpty()) {
    			if(r.getNumeroReservacion() != null) {
	    			if(r.getNumeroReservacion().startsWith(numero)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		if(!numeroReservaCubanacan.isEmpty()) {
    			if(r.getNumeroReservaCubanacan() != null) {
	    			if(r.getNumeroReservaCubanacan().startsWith(numeroReservaCubanacan)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		if(!numeroReservaCubatur.isEmpty()) {
    			if(r.getNumeroReservaCubatur() != null) {
	    			if(r.getNumeroReservaCubatur().startsWith(numeroReservaCubatur)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		if(adicionar)
    			lista.add(r);
    	}
    	
    	return lista;
	}
	
	public List<Reservacion> reservacionesMes(Date fecha) {
		return reservacionDao.obtenerReservaciones(fecha);
	}
	
	public List<Reservacion> reservacionesDisponibles(Date fecha) {
		return reservacionDao.obtenerReservacionesDisponibles(fecha);
	}
	
	public List<Reservacion> reservacionesCasa(Integer id) {
		List<Reservacion> reservaciones = reservacionDao.obtenerReservacionesAsignadas();
		List<Reservacion> lista = new ArrayList<Reservacion>();
		
		for(int i = 0; i < reservaciones.size(); i ++) {
			Reservacion reservacion = reservaciones.get(i);
			
			if(id.equals(reservacion.getCasa().getId()))
				lista.add(reservacion);
		}
		
		return lista;
	}
	
	public void reservarCasa(Reservacion reservacion, Integer id) throws Exception {
		List<Reservacion> reservaciones = reservacionesCasa(id);
		
		for(Reservacion r : reservaciones) {
			coinciden(reservacion, r);
		}
		
		reservacion.setCasa(new Casa(id));
		actualizar(reservacion);
	}
	
	private boolean coinciden(Reservacion nueva, Reservacion vieja) throws Exception {
		if(nueva.getFechaLlegada().getTime() > vieja.getFechaLlegada().getTime()) {
			if(nueva.getFechaLlegada().getTime() < vieja.getFechaPartida().getTime())
				throw new Exception("Esta casa ya esta reservada del " + vieja.getFechaLlegada() + " hasta " + vieja.getFechaPartida());
		}
		
		else if(nueva.getFechaLlegada().getTime() < vieja.getFechaLlegada().getTime()) {
			if(nueva.getFechaPartida().getTime() > vieja.getFechaLlegada().getTime())
				throw new Exception("Esta casa ya esta reservada del " + vieja.getFechaLlegada() + " hasta " + vieja.getFechaPartida());
		}
		
		return false;
	}
}
