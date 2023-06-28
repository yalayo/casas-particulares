package app.registro.productos.service;

import java.util.List;

import app.comun.service.ApplicationService;
import app.registro.productos.domain.Producto;

public interface ProductoService extends ApplicationService {
	public List<Producto> consultar(String nombre);
}
