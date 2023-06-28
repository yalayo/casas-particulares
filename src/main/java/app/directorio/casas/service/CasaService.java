package app.directorio.casas.service;

import java.util.List;

import app.comun.service.ApplicationService;
import app.directorio.casas.domain.Casa;
import app.directorio.configuracion.domain.Criterio;

public interface CasaService extends ApplicationService {
	public List<Casa> filtrarCasas(List<Criterio> criterios);
}
