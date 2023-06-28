<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="datosPersona" styleClass="w100">            
		<h:outputLabel value="Direccion" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datos" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Nombre" for="nombre"/>				
				<h:inputText id="nombre" value="#{personaManejado.persona.nombre}" styleClass="val-nombre required w100 float_right" />
								
				<h:outputLabel value="Primer Apellido" for="apellido1"/>				
				<h:inputText id="apellido1" value="#{personaManejado.persona.primerApellido}" styleClass="val-nombre required w100 float_right" />
			
				<h:outputLabel value="Segundo Apellido" for="apellido2"/>				
				<h:inputText id="apellido2" value="#{personaManejado.persona.segundoApellido}" styleClass="val-nombre w100 float_right" />	
							
				<h:outputLabel value="Numero de Carnet" for="carnet"/>				
				<h:inputText id="carnet" value="#{personaManejado.persona.carnetIdentidad}" maxlength="11" styleClass="validate-digits required w100 float_right" />
				
				<h:outputLabel value="Sexo" for="sexo"/>				
				<h:selectOneMenu id="sexo" value="#{personaManejado.persona.sexo}" styleClass="label w100">
					<f:selectItem id="ok" itemLabel="Masculino" itemValue="M"/>
					<f:selectItem id="no" itemLabel="Femenino" itemValue="F"/>				
				</h:selectOneMenu>
				
				<h:outputLabel value="Telefono" for="telefono"/>				
				<h:inputText id="telefono" value="#{personaManejado.persona.telefono}" styleClass="validate-digits w100 float_right" />
				
				<h:outputLabel value="Celular" for="celular"/>				
				<h:inputText id="celular" value="#{personaManejado.persona.celular}" styleClass="validate-digits w100 float_right" />
				
				<h:outputLabel value="Correos" for="correos"/>				
				<h:inputText id="correos" value="#{personaManejado.persona.correos}" styleClass="validate-email w100 float_right" />
				
				<h:outputLabel value="Direccion" rendered="#{personaManejado.registrada}"/>
				<a4j:commandLink immediate="true" actionListener="#{personaManejado.registrarDireccion}" value="#{personaManejado.direccion}" styleClass="float_right" status="globalStatus" rendered="#{personaManejado.registrada}" />
			</h:panelGrid>
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{personaManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="datosPersona"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="guardar" value="Guardar" actionListener="#{personaManejado.actualizarDatos}" disabled="false" reRender="formulario" style="margin-right:348px;">
				<app:validationConfigurationGenerator id="validatorGuardar" for="datosPersona"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{personaManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>