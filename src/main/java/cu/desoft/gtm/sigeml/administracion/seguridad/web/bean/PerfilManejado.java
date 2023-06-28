package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import org.springframework.dao.DataIntegrityViolationException;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class PerfilManejado extends PerfilBaseManejado{
	private String nombre;
	private List<Permiso> permisos;
	
	private HtmlDataTable table;
	
	public PerfilManejado() {
		super();				
	}
	
	private Set<Permiso> obtenerPermisosSeleccionados() {
		Set<Permiso> seleccionados = new HashSet<Permiso>();
		
		for(int i = 0; i < permisos.size(); i ++) {
			Permiso permiso = permisos.get(i);
		
			if(permiso.isSeleccionado())
				seleccionados.add(permiso);
		}
		
		return seleccionados;
	}
		
	public void incluir(ActionEvent e) {
		try {
			Perfil perfil = new Perfil();		
			perfil.setNombre(nombre);			
		
			perfil.setPermisos(obtenerPermisosSeleccionados());
		
			getPerfilService().incluirPerfil(perfil);
		
			removeBeanSession("listarPerfilManejado");
			removeBeanSession("perfilManejado");
			adicionarMensajeInformacion("El perfil ha sido agregado correctamente.");
			
			getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPerfil.jsp");
		}
		
		catch (DataIntegrityViolationException ex) {
			adicionarMensajeError("Ya existe el perfil. Por favor verifique el nombre.");
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

	public List<Permiso> getPermisos() {
		if(permisos == null)
			permisos = getPermisoService().listarPermisos();
		
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
