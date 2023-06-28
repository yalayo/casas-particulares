package app.registro.productos.web.bean;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.registro.productos.service.ProductoService;

public class ProductoBaseManejado extends ApplicationBaseBean {
	private ProductoService productoService;
	
	public ProductoBaseManejado() {
		super();
	}

	public ProductoService getProductoService() {
		if(productoService == null)
			productoService = (ProductoService)getBeanValue("productoService");
		
		return productoService;
	}
}
