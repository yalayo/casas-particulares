<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<t:div styleClass="inferior separa_div_abajo">
	<h:outputLabel styleClass="encabezado" value="Datos" />
	<h:panelGrid columns="2" styleClass="tabla_layout w100" columnClasses="w50 separador_der, w50">
		<t:div>
			<h:panelGrid columns="2" styleClass="tabla_datos w100" columnClasses="header,null" rowClasses="null, alt" rendered="true">
				<h:outputText value="Nomenclador" rendered="true" />
				<h:outputText value="#{mostrarNomencladorManejado.nomenclador.value}" rendered="true" />				
				<h:outputText value="Tipo de Nomenclador" rendered="true" />
				<h:outputText value="#{mostrarNomencladorManejado.nomenclador.keyWord}" rendered="true" />
			</h:panelGrid>
		</t:div>
	</h:panelGrid>

	<h:form>
		<t:div styleClass="botones separa_div_arriba" style="width:100%">
			<a4j:commandButton actionListener="#{mostrarNomencladorManejado.aceptar}" immediate="true" value="Aceptar" eventsQueue="ubig" requestDelay="3" reRender="formulario"/>
			<a4j:commandButton actionListener="#{mostrarNomencladorManejado.modificar}"  immediate="true" value="Modificar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" reRender="formulario" />
		</t:div>
	</h:form>
</t:div>