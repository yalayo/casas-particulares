package app.directorio.casas.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.comun.service.impl.ApplicationServiceImpl;
import app.directorio.casas.domain.Casa;
import app.directorio.casas.service.CasaService;
import app.directorio.configuracion.domain.Criterio;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.datos.domain.Dato;
import app.directorio.datos.service.DatoService;

public class CasaServiceImpl extends ApplicationServiceImpl implements CasaService {
	private DatoService datoService;
	
	public CasaServiceImpl() {
		
	}
	
	public void setDatoService(DatoService datoService) {
		this.datoService = datoService;
	}

	@Override
	public List<Casa> filtrarCasas(List<Criterio> criterios) {
		List<Casa> casas = (List<Casa>)applicationDao.obtenerTodos(Casa.class);
		List<Casa> lista = new ArrayList<Casa>();
				
		for(int i = 0; i < casas.size(); i ++) {
			Casa casa = casas.get(i);			
			List<Dato> datos = datoService.obtenerDatosCasa(casa.getId());
			Map<Integer, Dato> map = new HashMap<Integer, Dato>();
			boolean saltar = false;
			
			for(int j = 0; j < datos.size(); j ++) {
				Dato dato = datos.get(j);
				Pregunta pregunta = dato.getPregunta();
				
				map.put(pregunta.getId(), dato);
			}
			
			for(int j = 0; j < criterios.size(); j ++) {
				Criterio criterio = criterios.get(j);
				Pregunta p = criterio.getPregunta();
				Dato d = map.get(p.getId());
								
				if(d != null) {
					String respuesta = d.getRespuesta();
					String valor = criterio.getValor();
					
					if(!respuesta.contains(valor)) {
						saltar = true;
						break;
					}
				}
			}
			
			if(!saltar)
				lista.add(casa);
		}
		
		return lista;
	}
}
