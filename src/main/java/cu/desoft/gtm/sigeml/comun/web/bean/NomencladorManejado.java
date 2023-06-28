package cu.desoft.gtm.sigeml.comun.web.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.jsf.util.InterfaceUtils;

public class NomencladorManejado extends NomencladorBaseManejado {
	private String value;
	private String descripcion;
	private String tipoNomenclador;
	private Nomenclador padre;
	
	private List<SelectItem> padres;
	
	public NomencladorManejado() {
		super();
		
	}

	public void incluir(ActionEvent e) {
		Nomenclador nomenclador = new Nomenclador();
		
		nomenclador.setValue(value);
		nomenclador.setKeyWord(tipoNomenclador);
		
		removeBeanSession("listarNomencladorManejado");
		getNomencladorService().salvar(nomenclador);
		adicionarMensajeInformacion("El nomenclador ha sido agregado correctamente.");
		getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoNomenclador() {
		return tipoNomenclador;
	}

	public void setTipoNomenclador(String tipoNomenclador) {
		this.tipoNomenclador = tipoNomenclador;
	}

	public Nomenclador getPadre() {
		return padre;
	}

	public void setPadre(Nomenclador padre) {
		this.padre = padre;
	}

	public List<SelectItem> getPadres() {
		if(padres == null)
			padres = InterfaceUtils.crearSelectItemAsObject(getNomencladorService().obtenerPadres().iterator());
		
		return padres;
	}	
}
