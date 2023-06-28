package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import org.springframework.dao.DataIntegrityViolationException;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class PermisoManejado extends PermisoBaseManejado {
	private String nombre;
	private String descripcion;
		
	public PermisoManejado() {
		super();
		
	}
	
	public void incluir(ActionEvent e) {
		try {
			Permiso permiso = new Permiso();
		
			permiso.setNombre("PERMISO_" + nombre);
			permiso.setDescripcion(descripcion);
			
			getPermisoService().incluirPermiso(permiso);
			
			removeBeanSession("listarPermisoManejado");
			removeBeanSession("permisoManejado");
			adicionarMensajeInformacion("El permiso ha sido agregado correctamente.");
			getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPermiso.jsp");
		}
		
		catch (DataIntegrityViolationException ex) {
			adicionarMensajeError("Ya existe el permiso. Por favor rectifique los datos.");			
		}
	}
	
	public void cancelar(ActionEvent e){
		retornarUrlAnterior();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
