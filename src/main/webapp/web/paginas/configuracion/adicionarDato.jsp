<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarPregunta" styleClass="w100">            
		<h:outputLabel value="Pregunta" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="secc" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero" />
		  	    <h:outputLabel value="#{datoManejado.pregunta.numero}" />
			</h:panelGrid>
					
			
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{datoManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarPregunta"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="guardar" value="Guardar" actionListener="#{datoManejado.actualizarDatos}" disabled="false" reRender="formulario" style="margin-right:353px;">
				<app:validationConfigurationGenerator id="validatorGuardar" for="adicionarPregunta"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{datoManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>