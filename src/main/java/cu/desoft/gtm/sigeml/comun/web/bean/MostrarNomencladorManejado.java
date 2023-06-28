package cu.desoft.gtm.sigeml.comun.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public class MostrarNomencladorManejado extends NomencladorBaseManejado {
	private Nomenclador nomenclador;
	
	public MostrarNomencladorManejado() {
		
	}
	
	public void modificar(ActionEvent e) {					
		ModificarNomencladorManejado modificar = (ModificarNomencladorManejado) getBeanValue("modificarNomencladorManejado");
		modificar.setNomenclador(nomenclador);
		modificar.setUrlAnterior("/web/paginas/administracion/nomenclador/verNomenclador.jsp");
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/modificarNomenclador.jsp");
	}
   
    public void aceptar(ActionEvent e) {					
    	retornarUrlAnterior();
	}
    
    public void cancelar(ActionEvent e) {					
    	retornarUrlAnterior();
	}

	public Nomenclador getNomenclador() {
		return nomenclador;
	}

	public void setNomenclador(Nomenclador nomenclador) {
		this.nomenclador = nomenclador;
	}
}
