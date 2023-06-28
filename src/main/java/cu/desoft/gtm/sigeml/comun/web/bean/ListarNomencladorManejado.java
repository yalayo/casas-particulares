package cu.desoft.gtm.sigeml.comun.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public class ListarNomencladorManejado extends NomencladorBaseManejado {
	
	private List<Nomenclador> nomencladores;
	
	private HtmlDataTable table;
	
	public ListarNomencladorManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("nomencladorManejado");
		removeBeanSession("listarNomencladorManejado");
		NomencladorManejado adicionar = (NomencladorManejado) getBeanValue("nomencladorManejado");

		adicionar.setUrlAnterior("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/adicionarNomenclador.jsp");
	}
	
	public void modificar(ActionEvent e) {
		Nomenclador nomenclador = (Nomenclador)table.getRowData();

		removeBeanSession("modificarNomencladorManejado");
		ModificarNomencladorManejado modificar = (ModificarNomencladorManejado) getBeanValue("modificarNomencladorManejado");

		modificar.setNomenclador(nomenclador);
		modificar.setUrlAnterior("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");
		
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/modificarNomenclador.jsp");
	}
	
	public void mostrar(ActionEvent e){
		Nomenclador nomenclador = (Nomenclador)table.getRowData();

		removeBeanSession("mostrarNomencladorManejado");
		MostrarNomencladorManejado mostrar = (MostrarNomencladorManejado) getBeanValue("mostrarNomencladorManejado");

		mostrar.setNomenclador(nomenclador);
		mostrar.setUrlAnterior("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/verNomenclador.jsp");
	}

	public List<Nomenclador> getNomencladores() {
		if(nomencladores == null)
			nomencladores = getNomencladorService().listarNomencladores();
		
		return nomencladores;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
