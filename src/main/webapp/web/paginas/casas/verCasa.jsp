<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarCasa" styleClass="w100">
		<h:outputLabel value="Datos de la Casa" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datosCasa" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Nombre" />
				<h:outputLabel value="#{casaManejado.nombreCasa}" styleClass="float_right" />
			</h:panelGrid>
			
			<h:panelGrid id="dirCasa" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Direccion"/>
				<h:outputLabel value="#{casaManejado.direccionCasa}" styleClass="float_right"/>
			</h:panelGrid>
			
			<h:panelGrid id="duenhoCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Dueño"/>
				<h:outputLabel value="#{casaManejado.duenhoCasa}" styleClass="float_right"/>
			</h:panelGrid>
			
			<h:panelGrid id="adminCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Administrator"/>
				<h:outputLabel value="#{casaManejado.administradorCasa}" styleClass="float_right"/>				
			</h:panelGrid>
			
			<h:panelGrid id="beneficiadoCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Beneficiado"/>
				<h:outputLabel value="#{casaManejado.beneficiadoCasa}" styleClass="float_right"/>
			</h:panelGrid>
			
			<h:panelGrid id="agenteCobroCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Cobrador"/>
				<h:outputLabel value="#{casaManejado.cobradorCasa}" styleClass="float_right"/>
			</h:panelGrid>
			
			<h:panelGrid id="datosFinancieros" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Cuenta"/>
				<h:outputLabel value="Registrar" styleClass="float_right"/>
			</h:panelGrid>
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{casaManejado.cancelar}" disabled="false" reRender="formulario" style="margin-right:10px;" />
		</t:div>                
	</t:div>
</h:form>