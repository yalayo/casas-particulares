package app.directorio.configuracion.service;

import java.util.List;

import app.comun.service.ApplicationService;
import app.directorio.configuracion.domain.Pregunta;

public interface PreguntaService extends ApplicationService {
	public List<Pregunta> consultar(String texto);
	public List<Pregunta> obtenerPreguntasPorSeccion(String seccion);
}
