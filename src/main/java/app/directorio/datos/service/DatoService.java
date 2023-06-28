package app.directorio.datos.service;

import java.util.List;

import app.comun.service.ApplicationService;
import app.directorio.datos.domain.Dato;

public interface DatoService extends ApplicationService {
	public List<Dato> obtenerDatosCasa(Integer id);
	public List<Dato> obtenerDatosHabitacion(Integer id);
}
