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
				<h:outputLabel value="Seccion" for="seccion"/>
		  	    
				<h:selectOneMenu id="seccion" value="#{preguntaManejado.seccion}" styleClass="label w100" >
					<f:selectItem id="edif" itemLabel="Datos del Edificio" itemValue="edif"/>
					<f:selectItem id="vivienda" itemLabel="Datos de la Vivienda" itemValue="vivienda"/>
					<f:selectItem id="habitacion" itemLabel="Datos de la Habitacion" itemValue="habitacion"/>		
				</h:selectOneMenu>
			</h:panelGrid>
					
			<a4j:region id="regionSubmitTipoResp">
			<t:div id="selecc">
			<h:panelGrid id="tipoR" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Tipo de Respuesta" for="tipoResp"/>
		  	    
				<h:selectOneMenu id="tipoResp" value="#{preguntaManejado.tipoRespuesta}" styleClass="label w100" >
					<f:selectItem id="respEsp" itemLabel="Especifica" itemValue="esp"/>
					<f:selectItem id="respBin" itemLabel="Binaria" itemValue="bin"/>
					<f:selectItem id="respSel" itemLabel="Seleccionable" itemValue="sel"/>
					<f:selectItem id="respFech" itemLabel="Fecha" itemValue="fech"/>	
					
					<a4j:support event="onchange" id="supportRegionSubmit" reRender="selecc"/>			
				</h:selectOneMenu>
			</h:panelGrid>
			
			<h:panelGrid id="preguntaSimple" columns="2" columnClasses="w50, w50" styleClass="w100" rendered="#{preguntaManejado.mostrarPreguntaSimple}">
				<h:outputLabel value="Pregunta Simple" />
				<h:selectBooleanCheckbox id="checkSimple" value="#{preguntaManejado.preguntaSimple}" styleClass="checkbox float_right" />	
			</h:panelGrid>
			
			<h:panelGrid id="preguntaSel" columns="2" columnClasses="w50, w50" styleClass="w100" rendered="#{preguntaManejado.preguntaSeleccion}" >
				<h:outputLabel value="Posibles Respuestas" />
				<a4j:commandLink immediate="true" actionListener="#{preguntaManejado.registrarRespuestas}" value="#{preguntaManejado.registro}" styleClass="float_right"  status="globalStatus"  />			
			</h:panelGrid>
			</t:div>
			</a4j:region>
			
			<h:panelGrid id="numeroPreg" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero" for="numero"/>				
				<h:inputText id="numero" value="#{preguntaManejado.numero}" styleClass="validate-digits required w100 float_right" />
			</h:panelGrid>
			
			<h:panelGrid id="textoPreg" columns="1" columnClasses="w50, w50" styleClass="w100">				
				<h:outputLabel value="Texto" for="texto"/>				
				<h:inputTextarea id="texto" value="#{preguntaManejado.texto}" styleClass="required w100 float_right" />
			</h:panelGrid>
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{preguntaManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarPregunta"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="guardar" value="Guardar" actionListener="#{preguntaManejado.actualizarDatos}" disabled="false" reRender="formulario" style="margin-right:353px;">
				<app:validationConfigurationGenerator id="validatorGuardar" for="adicionarPregunta"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{preguntaManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>