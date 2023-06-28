package app.directorio.datos.service.impl;

import java.util.ArrayList;
import java.util.List;

import app.comun.service.impl.ApplicationServiceImpl;
import app.directorio.datos.domain.Dato;
import app.directorio.datos.service.DatoService;

public class DatoServiceImpl extends ApplicationServiceImpl implements DatoService {

	@Override
	public List<Dato> obtenerDatosCasa(Integer id) {
		List<Dato> datos = (List<Dato>)applicationDao.obtenerTodos(Dato.class);
		List<Dato> lista = new ArrayList<Dato>();
		
		for(int i = 0; i < datos.size(); i ++) {
			Dato d = datos.get(i);
			
			if(d.getCasa() != null)
				if(d.getCasa().getId().equals(id))
					lista.add(d);
		}
		
		return lista;
	}
	
	@Override
	public List<Dato> obtenerDatosHabitacion(Integer id) {
		List<Dato> datos = (List<Dato>)applicationDao.obtenerTodos(Dato.class);
		List<Dato> lista = new ArrayList<Dato>();
		
		for(int i = 0; i < datos.size(); i ++) {
			Dato d = datos.get(i);
			
			if(d.getHabitacion() != null)
				if(d.getHabitacion().getId().equals(id))
					lista.add(d);
		}
		
		return lista;
	}
}
