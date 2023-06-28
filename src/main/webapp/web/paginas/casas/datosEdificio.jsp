<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="datosEdificio" styleClass="w100">            
		<h:outputLabel value="Datos" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datos" columns="2" columnClasses="w50, field_mrg w50" styleClass="tabla_form w100">
				<h:outputLabel value="Numero" />
				<h:outputLabel value="#{datoManejado.pregunta.numero}" styleClass="w100 float_right"/>				
												
				<h:outputLabel value="Pregunta" />	
				<h:outputLabel value="#{datoManejado.pregunta.texto}" styleClass="w100 float_right"/>
			</h:panelGrid>
			
			<a4j:include styleClass="clase" id="tipo" viewId="#{datoManejado.url}" />
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{datoManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="datosEdificio"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="anterior" value="Anterior" actionListener="#{datoManejado.anterior}" rendered="#{datoManejado.anteriorEnabled}" reRender="formulario" style="margin-right:10px;"/>
			<a4j:commandButton id="siguiente" value="Siguiente" actionListener="#{datoManejado.siguiente}" rendered="#{datoManejado.siguienteEnabled}" reRender="formulario" />
						
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{datoManejado.cancelar}" disabled="false" style="float: right;" />
		</t:div>                
	</t:div>
</h:form>