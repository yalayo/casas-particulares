package cu.desoft.gtm.sigeml.comun.web.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.jsf.util.InterfaceUtils;

public class ModificarNomencladorManejado extends NomencladorBaseManejado{
	private Nomenclador nomenclador;
	private List<SelectItem> padres;
	
	public ModificarNomencladorManejado() {
		
	}
	
	public void modificar(ActionEvent e) {					
		getNomencladorService().modificar(nomenclador);
		adicionarMensajeInformacion("El nomenclador ha sido modificado correctamente.");
		removeBeanSession("listarNomencladorManejado");
		getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");
		
	}
	
	public void cancelar(ActionEvent e){
		retornarUrlAnterior();	
	}

	public Nomenclador getNomenclador() {
		return nomenclador;
	}

	public void setNomenclador(Nomenclador nomenclador) {
		this.nomenclador = nomenclador;
	}

	public List<SelectItem> getPadres() {
		if(padres == null)
			padres = InterfaceUtils.crearSelectItemAsObject(getNomencladorService().obtenerPadres().iterator());
		
		return padres;
	}
}
