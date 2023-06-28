package app.registro.reservaciones.dao;

import java.util.Date;
import java.util.List;

import app.comun.dao.ApplicationDao;
import app.registro.reservaciones.domain.Reservacion;

public interface ReservacionDao extends ApplicationDao {
	public List<Reservacion> obtenerReservaciones(Date fecha);
	public List<Reservacion> obtenerReservacionesDisponibles(Date fecha);
	public List<Reservacion> obtenerReservacionesAsignadas();
}
