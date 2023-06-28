package app.registro.productos.service.impl;

import java.util.ArrayList;
import java.util.List;

import app.comun.service.impl.ApplicationServiceImpl;
import app.registro.productos.domain.Producto;
import app.registro.productos.service.ProductoService;

public class ProductoServiceImpl extends ApplicationServiceImpl implements ProductoService {
	
	public List<Producto> consultar(String nombre) {
		List<Producto> productos = (List<Producto>)obtenerTodos(Producto.class);
    	List<Producto> lista = new ArrayList<Producto>();
    	
    	for(int i = 0; i < productos.size(); i ++) {
    		Producto p = productos.get(i);
    		boolean adicionar = false;
    		
    		if(!nombre.isEmpty()) {
    			if(p.getNombre() != null) {
	    			if(p.getNombre().startsWith(nombre)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		else
    			lista.add(p);
    		
    		if(adicionar)
    			lista.add(p);
    	}
    	
    	return lista;
	}
}
