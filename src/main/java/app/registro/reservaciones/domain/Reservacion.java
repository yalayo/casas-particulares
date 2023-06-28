package app.registro.reservaciones.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.directorio.casas.domain.Casa;
import app.directorio.personas.domain.Persona;
import app.registro.productos.domain.Producto;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Reservacion extends EntidadPersistente {
	private String numeroReservacion;
	private String numeroTurmundo;
	private String turOperador;
	private String numeroReservaTurOperador;
	private String numeroReservaCubanacan;
	private String numeroReservaCubatur;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer cantidadPasajeros;
	private String anhoReservacion;
	private Date fechaSolicitud;
	private Date fechaLlegada;
	private Date fechaPartida;
	private String proveedorProducto;
	private String codigoProductoErl;
	private String codigoProductoTur;
	private String estadoReservacion;
	private String proveedorServicio;
	private String observaciones;
	
	private Persona reservante;
	private Casa casa;
	private Factura factura1;
	private Factura factura2;
	private Factura facturaErl;
	private Factura facturaCredito;
	
	private List<Persona> clientes;
	private List<Producto> productos;
		
	public Reservacion() {
		estadoReservacion = "NO";
	}
	
	public void adicionarProducto(Producto producto) {
		if(productos == null)
			productos = new ArrayList<Producto>();
		
		productos.add(producto);
	}
	
	public void eliminarProducto(Producto producto) {
		for(int i = 0; i < productos.size(); i ++) {
			Producto p = productos.get(i);
			
			if(p.getId().equals(producto.getId())) {
				productos.remove(i);
				break;
			}
		}
	}
	
	public void adicionarCliente(Persona persona) {
		if(clientes == null)
			clientes = new ArrayList<Persona>();
		
		clientes.add(persona);
	}

	public String getNumeroReservacion() {
		return numeroReservacion;
	}

	public void setNumeroReservacion(String numeroReservacion) {
		this.numeroReservacion = numeroReservacion;
	}

	public String getNumeroTurmundo() {
		return numeroTurmundo;
	}

	public void setNumeroTurmundo(String numeroTurmundo) {
		this.numeroTurmundo = numeroTurmundo;
	}

	public String getTurOperador() {
		return turOperador;
	}

	public void setTurOperador(String turOperador) {
		this.turOperador = turOperador;
	}

	public String getNumeroReservaTurOperador() {
		return numeroReservaTurOperador;
	}

	public void setNumeroReservaTurOperador(String numeroReservaTurOperador) {
		this.numeroReservaTurOperador = numeroReservaTurOperador;
	}

	public String getNumeroReservaCubanacan() {
		return numeroReservaCubanacan;
	}

	public void setNumeroReservaCubanacan(String numeroReservaCubanacan) {
		this.numeroReservaCubanacan = numeroReservaCubanacan;
	}

	public String getNumeroReservaCubatur() {
		return numeroReservaCubatur;
	}

	public void setNumeroReservaCubatur(String numeroReservaCubatur) {
		this.numeroReservaCubatur = numeroReservaCubatur;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getCantidadPasajeros() {
		return cantidadPasajeros;
	}

	public void setCantidadPasajeros(Integer cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}

	public String getAnhoReservacion() {
		return anhoReservacion;
	}

	public void setAnhoReservacion(String anhoReservacion) {
		this.anhoReservacion = anhoReservacion;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaPartida() {
		return fechaPartida;
	}

	public void setFechaPartida(Date fechaPartida) {
		this.fechaPartida = fechaPartida;
	}

	public String getProveedorProducto() {
		return proveedorProducto;
	}

	public void setProveedorProducto(String proveedorProducto) {
		this.proveedorProducto = proveedorProducto;
	}

	public String getCodigoProductoErl() {
		return codigoProductoErl;
	}

	public void setCodigoProductoErl(String codigoProductoErl) {
		this.codigoProductoErl = codigoProductoErl;
	}

	public String getCodigoProductoTur() {
		return codigoProductoTur;
	}

	public void setCodigoProductoTur(String codigoProductoTur) {
		this.codigoProductoTur = codigoProductoTur;
	}

	public String getEstadoReservacion() {
		return estadoReservacion;
	}

	public void setEstadoReservacion(String estadoReservacion) {
		this.estadoReservacion = estadoReservacion;
	}

	public String getProveedorServicio() {
		return proveedorServicio;
	}

	public void setProveedorServicio(String proveedorServicio) {
		this.proveedorServicio = proveedorServicio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Persona getReservante() {
		return reservante;
	}

	public void setReservante(Persona reservante) {
		this.reservante = reservante;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Factura getFactura1() {
		return factura1;
	}

	public void setFactura1(Factura factura1) {
		this.factura1 = factura1;
	}

	public Factura getFactura2() {
		return factura2;
	}

	public void setFactura2(Factura factura2) {
		this.factura2 = factura2;
	}

	public Factura getFacturaErl() {
		return facturaErl;
	}

	public void setFacturaErl(Factura facturaErl) {
		this.facturaErl = facturaErl;
	}

	public Factura getFacturaCredito() {
		return facturaCredito;
	}

	public void setFacturaCredito(Factura facturaCredito) {
		this.facturaCredito = facturaCredito;
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}