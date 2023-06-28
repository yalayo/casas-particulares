<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">
	<t:div id="adicionarNomenclador" styleClass="w100">
		<h:outputLabel value="Datos" styleClass="encabezado" />
		
		<h:panelGrid columns="2" styleClass="tabla_layout w100" columnClasses="w50, separador_izq w50">			
			<t:div>				
				<h:outputLabel value="Nomenclador" for="nom"/>				
				<h:inputText id="value" value="#{nomencladorManejado.value}" styleClass="required w100" />				
			</t:div>
			
			<h:panelGrid columns="2" columnClasses="w50, field_mrg w50" styleClass="tabla_form w100">
				<h:outputLabel value="Nomencladores" for="value"/>
		  	    <h:outputLabel value="Tipo de Nomenclador" for="tipoNomenclador"/>
		  	    
			    <h:selectOneMenu id="nom" value="#{nomencladorManejado.padre}" styleClass="label w100">
					<f:selectItems value="#{nomencladorManejado.padres}" />
					<f:converter converterId="selectItemsListConvertidor" />
				</h:selectOneMenu>
				<h:selectOneMenu id="tipoNomenclador" value="#{nomencladorManejado.tipoNomenclador}" styleClass="label w100">
					<f:selectItem id="ad" itemLabel="Administración" itemValue="Administración"/>
					<f:selectItem id="per" itemLabel="Periodístico" itemValue="Periodístico"/>				
				</h:selectOneMenu>
				
			</h:panelGrid>
		</h:panelGrid>
		<t:div>
		<h:outputLabel value="Descripción" for="descrip"/>
				<h:inputTextarea value="#{nomencladorManejado.descripcion}" id="texto" styleClass="w100" cols="3"/>
		</t:div>
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{nomencladorManejado.incluir}" disabled="false" reRender="formulario">
				<app:validationConfigurationGenerator id="validator" for="adicionarNomenclador"/>		
			</a4j:commandButton>
		</t:div>
	</t:div>
</h:form>