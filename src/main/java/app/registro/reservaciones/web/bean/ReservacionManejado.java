package app.registro.reservaciones.web.bean;

import javax.faces.event.ActionEvent;

import app.directorio.personas.web.bean.ListarPersonasManejado;
import app.directorio.personas.web.bean.PersonaManejado;
import app.registro.productos.web.bean.ProductoManejado;
import app.registro.productos.web.bean.ProductosReservacionManejado;
import app.registro.reservaciones.domain.Reservacion;

public class ReservacionManejado extends ReservacionBaseManejado {
	private Reservacion reservacion;
	
	private boolean numeroReservacion;
	private boolean numeroTurmundo;
	private boolean turOperador;
	private boolean numeroReservaTurOperador;
	private boolean nombre;
	private boolean primerApellido;
	private boolean segundoApellido;
	private boolean cantidadPasajeros;
	private boolean anhoReservacion;
	private boolean fechaSolicitud;
	private boolean fechaArribo;
	private boolean proveedorProducto;
	private boolean codigoProductoErl;
	private boolean codigoProductoTur;
	private boolean estadoServicio;
	private boolean proveedorServicio;
			
	public ReservacionManejado() {
		reservacion = new Reservacion();
	}
	
	public void reCargarReservacion() {
		reservacion = (Reservacion)obtenerPorId(reservacion.getId(), Reservacion.class);
	}
	
	public void actualizarDatos(ActionEvent e) {
		if(reservacion.getId() == null)
			salvar(reservacion);
		
		else
			actualizar(reservacion);
		
		adicionarMensajeInformacion("Los datos han sido actualizados.");
	}
	
	public void proxima(ActionEvent e) {
		if(reservacion.getId() == null)
			salvar(reservacion);
		
		else
			actualizar(reservacion);
		
		getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/otrosDatosReservacion.jsp");
	}
	
	public void registrarReservacion(ActionEvent e) {
		if(reservacion.getId() == null)
			salvar(reservacion);
		
		else
			actualizar(reservacion);
		
		adicionarMensajeInformacion("Reservacion registrada satisfactoriamente.");
		retornarUrlAnterior();
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void seleccionarReservante(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setReservacion(reservacion);
		listar.setMetodo("setReservante");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void seleccionarCliente(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setReservacion(reservacion);
		listar.setMetodo("adicionarCliente");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void registrarReservante(ActionEvent e) {
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(reservacion);
		personaManejado.setMetodo("setReservante");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarFactura1(ActionEvent e) {
		FacturaManejado facturaManejado = (FacturaManejado)getBeanValue("facturaManejado");
		facturaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		facturaManejado.setEntidad(reservacion);
		facturaManejado.setMetodo("setFactura1");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/facturas/adicionarFactura.jsp");
	}
	
	public void registrarFactura2(ActionEvent e) {
		FacturaManejado facturaManejado = (FacturaManejado)getBeanValue("facturaManejado");
		facturaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		facturaManejado.setEntidad(reservacion);
		facturaManejado.setMetodo("setFactura2");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/facturas/adicionarFactura.jsp");
	}
	
	public void registrarFacturaErl(ActionEvent e) {
		FacturaManejado facturaManejado = (FacturaManejado)getBeanValue("facturaManejado");
		facturaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		facturaManejado.setEntidad(reservacion);
		facturaManejado.setMetodo("setFacturaErl");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/facturas/adicionarFactura.jsp");
	}
	
	public void registrarFacturaCredito(ActionEvent e) {		
		FacturaManejado facturaManejado = (FacturaManejado)getBeanValue("facturaManejado");
		facturaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		facturaManejado.setEntidad(reservacion);
		facturaManejado.setMetodo("setFacturaCredito");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/facturas/adicionarFactura.jsp");
	}
	
	public void registrarProducto(ActionEvent e) {		
		ProductoManejado productoManejado = (ProductoManejado)getBeanValue("productoManejado");
		productoManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		productoManejado.setEntidad(reservacion);
		productoManejado.setMetodo("adicionarProducto");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/productos/adicionarProducto.jsp");
	}
	
	public void registrarCliente(ActionEvent e) {
		removeBeanSession("personaManejado");
		
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(reservacion);
		personaManejado.setMetodo("adicionarCliente");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void verProductos(ActionEvent e) {		
		ProductosReservacionManejado productosReservacionManejado = (ProductosReservacionManejado)getBeanValue("productosReservacionManejado");
		productosReservacionManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		productosReservacionManejado.setReservacion(reservacion);
		
		getApplicationBeanManejado().navigateTo("/web/paginas/productos/productosReservacion.jsp");
	}
	
	public void verClientes(ActionEvent e) {		
		/*ProductosReservacionManejado productosReservacionManejado = (ProductosReservacionManejado)getBeanValue("productosReservacionManejado");
		productosReservacionManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		productosReservacionManejado.setReservacion(reservacion);
		
		getApplicationBeanManejado().navigateTo("/web/paginas/productos/productosReservacion.jsp");*/
	}
	
	public void actualizarNumeroReservacion(ActionEvent e) {
		numeroReservacion = false;
	}
	
	public void actualizarNumeroTurmundo(ActionEvent e) {
		numeroTurmundo = true;
	}

/*public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}

public void actualizarNumeroReservacion(ActionEvent e) {
	
}*/

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public boolean isNumeroReservacion() {
		if(reservacion.getNumeroReservacion() != null)
			return false;
			
		return numeroReservacion;
	}

	public boolean isNumeroTurmundo() {
		return numeroTurmundo;
	}

	public boolean isTurOperador() {
		return turOperador;
	}

	public boolean isNumeroReservaTurOperador() {
		return numeroReservaTurOperador;
	}

	public boolean isNombre() {
		return nombre;
	}

	public boolean isPrimerApellido() {
		return primerApellido;
	}

	public boolean isSegundoApellido() {
		return segundoApellido;
	}

	public boolean isCantidadPasajeros() {
		return cantidadPasajeros;
	}

	public boolean isAnhoReservacion() {
		return anhoReservacion;
	}

	public boolean isFechaSolicitud() {
		return fechaSolicitud;
	}

	public boolean isFechaArribo() {
		return fechaArribo;
	}

	public boolean isProveedorProducto() {
		return proveedorProducto;
	}

	public boolean isCodigoProductoErl() {
		return codigoProductoErl;
	}

	public boolean isCodigoProductoTur() {
		return codigoProductoTur;
	}

	public boolean isEstadoServicio() {
		return estadoServicio;
	}

	public boolean isProveedorServicio() {
		return proveedorServicio;
	}

	public boolean isRegistrada() {
		if(reservacion != null) {
			if(reservacion.getNumeroReservacion() != null)
				return true;
		}
		
		return false;
	}
	
	public String getReservante() {
		if(reservacion.getReservante() == null)
			return "Registrar";
		
		return reservacion.getReservante().toString();
	}

	public String getFactura1() {
		if(reservacion.getFactura1() == null)
			return "Registrar";
		
		return reservacion.getFactura1().toString();
	}

	public String getFactura2() {
		if(reservacion.getFactura2() == null)
			return "Registrar";
		
		return reservacion.getFactura2().toString();
	}

	public String getFacturaErl() {
		if(reservacion.getFacturaErl() == null)
			return "Registrar";
		
		return reservacion.getFacturaErl().toString();
	}

	public String getFacturaCredito() {
		if(reservacion.getFacturaCredito() == null)
			return "Registrar";
		
		return reservacion.getFacturaCredito().toString();
	}
	
	public String getProducto() {
		if(reservacion.getProductos() == null)
			return "Sin productos";
		
		else
			return reservacion.getProductos().size() + " Registrado(s)";
	}
	
	public String getCliente() {
		if(reservacion.getClientes() == null)
			return "Sin clientes";
		
		else
			return reservacion.getClientes().size() + " Registrado(s)";
	}
}
