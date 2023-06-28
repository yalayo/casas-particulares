package app.registro.reservaciones.service;

import java.util.Date;
import java.util.List;

import app.comun.service.ApplicationService;
import app.registro.reservaciones.domain.Reservacion;

public interface ReservacionService extends ApplicationService {
	public List<Reservacion> consultar(String nombre, String numero, String numeroReservaCubanacan, String numeroReservaCubatur);
	public List<Reservacion> reservacionesMes(Date fecha);
	public List<Reservacion> reservacionesDisponibles(Date fecha);
	public List<Reservacion> reservacionesCasa(Integer id);
	public void reservarCasa(Reservacion reservacion, Integer id) throws Exception;
}
