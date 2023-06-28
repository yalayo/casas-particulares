<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarFactura" styleClass="w100">            
		<h:outputLabel value="Factura" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datos" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero" for="numero"/>				
				<h:inputText id="numero" value="#{facturaManejado.factura.numero}" styleClass="val-numReserva required w100 float_right" />
								
				<h:outputLabel value="Fecha" for="fecha"/>
				<rich:calendar id="fecha" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="float_right" value="#{facturaManejado.factura.fecha}" />
				
				<h:outputLabel value="Monto CUC" for="montoCuc"/>				
				<h:inputText id="montoCuc" value="#{facturaManejado.factura.montoCuc}" styleClass="required validate-number w100 float_right" />
			
				<h:outputLabel value="Monto Euro" for="montoEuro"/>				
				<h:inputText id="montoEuro" value="#{facturaManejado.factura.montoEuro}" styleClass="validate-number w100 float_right" />	
							
				<h:outputLabel value="Monto USD" for="montoUsd"/>				
				<h:inputText id="montoUsd" value="#{facturaManejado.factura.montoUsd}" styleClass="validate-number w100 float_right" />
			</h:panelGrid>
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{facturaManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarFactura"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{facturaManejado.cancelar}" disabled="false" />
		</t:div>                
	</t:div>
</h:form>