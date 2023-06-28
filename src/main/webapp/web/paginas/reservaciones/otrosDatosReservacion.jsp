<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="otrosDatosReservacion" styleClass="w100">            
		<h:outputLabel value="Otros Datos" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">			
			<h:panelGrid id="reservante" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Reservante"/>
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.registrarReservante}" value="#{reservacionManejado.reservante}" styleClass="float_right" status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.seleccionarReservante}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>	
			
			<h:panelGrid id="clientes" columns="4" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Clientes"/>
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.verClientes}" value="#{reservacionManejado.cliente}" styleClass="float_right"  status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.registrarCliente}" value="Registrar" styleClass="float_right"  status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.seleccionarCliente}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="prods" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Productos"/>
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.verProductos}" value="#{reservacionManejado.producto}" styleClass="float_right"  status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.registrarProducto}" value="Registrar" styleClass="float_right"  status="globalStatus" />
			</h:panelGrid>		
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="terminar" value="Aceptar" actionListener="#{reservacionManejado.registrarReservacion}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorTerminar" for="adicionarReservacion"/>		
			</a4j:commandButton>
						
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{reservacionManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>