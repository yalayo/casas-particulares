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
				<h:outputLabel value="Nombre" for="nombreCasa"/>				
				<h:inputText id="nombreCasa" value="#{casaManejado.nombreCasa}" styleClass="val-nombre required w100 float_right" rendered="#{not casaManejado.mostrarNombre}"  />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.actualizarNombre}" value="#{casaManejado.nombreCasa}" styleClass="float_right" status="globalStatus" rendered="#{casaManejado.mostrarNombre}" reRender="datosCasa" />
			</h:panelGrid>
			
			<t:div id="datos" rendered="#{casaManejado.mostrarDatos}">
			<h:panelGrid id="dirCasa" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Direccion"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDireccionCasa}" value="#{casaManejado.direccionCasa}" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="duenhoCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Dueño"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDuenhoCasa}" value="#{casaManejado.duenhoCasa}" styleClass="float_right"  status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.seleccionarDuenho}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="adminCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Administrator"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarAdministradorCasa}" value="#{casaManejado.administradorCasa}" styleClass="float_right" status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.seleccionarAdministrador}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="beneficiadoCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Beneficiado"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarBeneficiadoCasa}" value="#{casaManejado.beneficiadoCasa}" styleClass="float_right" status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.seleccionarBeneficiado}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
				
			</h:panelGrid>
			
			<h:panelGrid id="agenteCobroCasa" columns="3" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Cobrador"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarCobradorCasa}" value="#{casaManejado.cobradorCasa}" styleClass="float_right" status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.seleccionarCobrador}" value="Seleccionar" styleClass="float_right" status="globalStatus" />
				
			</h:panelGrid>
			
			<h:panelGrid id="datosFinancieros" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Cuenta"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDatosFinancieros}" value="Registrar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="datosEdificio" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Datos del Edificio"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDatosEdificio}" value="Registrar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="datosVivienda" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Datos de la Vivienda"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDatosVivienda}" value="Registrar" styleClass="float_right" status="globalStatus" />
			</h:panelGrid>
			
			<h:panelGrid id="datosHabitacion" columns="2" columnClasses="w50, w50" styleClass="w100" onmouseover="makeBold(this);" onmouseout="unMakeBold(this);">
				<h:outputLabel value="Datos de las Habitaciones"/>
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.registrarDatosHabitacion}" value="Registrar" styleClass="float_right" status="globalStatus" />
				<a4j:commandLink immediate="true" actionListener="#{casaManejado.seleccionarHabitacion}" value="Seleccionar" styleClass="float_right" status="globalStatus" rendered="false"/>
			</h:panelGrid>
			</t:div>
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{casaManejado.actualizarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarCasa"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="terminar" value="Terminar" actionListener="#{casaManejado.registrarCasa}" disabled="false" reRender="formulario" style="margin-right:364px;">
				<app:validationConfigurationGenerator id="validatorTerminar" for="adicionarCasa"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{casaManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>