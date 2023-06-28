<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="datosDireccion" styleClass="w100">            
		<h:outputLabel value="Direccion" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datos" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Calle" for="calle"/>				
				<h:inputText id="calle" value="#{direccionManejado.direccion.calle}" styleClass="required w100 float_right" />
								
				<h:outputLabel value="Edificio" for="edificio"/>				
				<h:inputText id="edificio" value="#{direccionManejado.direccion.edificio}" styleClass="w100 float_right" />
			
				<h:outputLabel value="Apartamento" for="apto"/>				
				<h:inputText id="apto" value="#{direccionManejado.direccion.apartamento}" styleClass="required w100 float_right" />	
								
				<h:outputLabel value="Entre Calles" for="ecalle"/>				
				<h:inputText id="ecalle" value="#{direccionManejado.direccion.entreCalles}" styleClass="required w100 float_right" />
				
				<h:outputLabel value="Barrio" for="barrio"/>				
				<h:inputText id="barrio" value="#{direccionManejado.direccion.barrio}" styleClass="w100 float_right" />
				
				<h:outputLabel value="Reparto" for="reparto"/>				
				<h:inputText id="reparto" value="#{direccionManejado.direccion.reparto}" styleClass="w100 float_right" />
				
				<h:outputLabel value="Ciudad o Lugar" for="ciudad"/>				
				<h:inputText id="ciudad" value="#{direccionManejado.direccion.ciudad}" styleClass="required w100 float_right" />
				
				<h:outputLabel value="Municipio" for="municipio"/>				
				<h:inputText id="municipio" value="#{direccionManejado.direccion.municipio}" styleClass="required w100 float_right" />
				
				<h:outputLabel value="Provincia" for="provincia"/>				
				<h:inputText id="provincia" value="#{direccionManejado.direccion.provincia}" styleClass="required w100 float_right" />
			</h:panelGrid>
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{direccionManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="datosDireccion"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{direccionManejado.cancelar}" disabled="false" />
		</t:div>                
	</t:div>
</h:form>