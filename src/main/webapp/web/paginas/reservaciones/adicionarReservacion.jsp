<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarReservacion" styleClass="w100">            
		<h:outputLabel value="Registrar Reservacion" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="numero" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero de Reservacion" for="numeroReservacion"/>				
				<h:inputText id="numeroReservacion" value="#{reservacionManejado.reservacion.numeroReservacion}" maxlength="4" styleClass="required validate-digits w100 float_right" rendered="#{not reservacionManejado.numeroReservacion}" />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.actualizarNumeroReservacion}" value="#{reservacionManejado.reservacion.numeroReservacion}" styleClass="float_right" status="globalStatus" rendered="#{reservacionManejado.numeroReservacion}" reRender="numero" />
			</h:panelGrid>
			
			<h:panelGrid id="numTurmundo" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero Tur Mundo" for="numeroReservacion"/>				
				<h:inputText id="numeroTurmundo" value="#{reservacionManejado.reservacion.numeroTurmundo}" maxlength="4" styleClass="validate-digits w100 float_right" rendered="#{not reservacionManejado.numeroTurmundo}"  />
				<a4j:commandLink immediate="true" actionListener="#{reservacionManejado.actualizarNumeroTurmundo}" value="#{reservacionManejado.reservacion.numeroTurmundo}" styleClass="float_right" status="globalStatus" rendered="#{reservacionManejado.numeroTurmundo}" reRender="numTurmundo" />
			</h:panelGrid>
			
			<h:panelGrid id="tOperador" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Tur Operador" for="turOperador"/>				
				<h:inputText id="turOperador" value="#{reservacionManejado.reservacion.turOperador}" styleClass="validate-alpha w100 float_right" rendered="true" maxlength="3" />
			</h:panelGrid>
			
			<h:panelGrid id="numeroReservaTo" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Numero de Reserva Tur Operador" for="numeroReservaTurOperador"/>				
				<h:inputText id="numeroReservaTurOperador" value="#{reservacionManejado.reservacion.numeroReservaTurOperador}" styleClass="val-numTO w100 float_right" rendered="true"  />
			</h:panelGrid>
								
			<h:panelGrid id="fechaSol" columns="2" columnClasses="w50," styleClass="w100">
				<h:outputLabel value="Fecha de Solicitud" for="fechaSolicitud"/>									
				<rich:calendar id="fechaSolicitud" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="required float_right" value="#{reservacionManejado.reservacion.fechaSolicitud}" />
			</h:panelGrid>
			
			<h:panelGrid id="fechaLl" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Fecha de Llegada" for="fechaLlegada"/>
				<rich:calendar id="fechaLlegada" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="required float_right" value="#{reservacionManejado.reservacion.fechaLlegada}" />
			</h:panelGrid>
			
			<h:panelGrid id="fechaPar" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Fecha de Partida" for="fechaPartida"/>
				<rich:calendar id="fechaPartida" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="required float_right" value="#{reservacionManejado.reservacion.fechaPartida}" />
			</h:panelGrid>
						
			<h:panelGrid id="observ" columns="1" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Observaciones" for="observaciones"/>				
				<h:inputTextarea id="observaciones" value="#{reservacionManejado.reservacion.observaciones}" styleClass="w100" rendered="true"  />
			</h:panelGrid>		
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="terminar" value="Aceptar" actionListener="#{reservacionManejado.proxima}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorTerminar" for="adicionarReservacion"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="aceptar" value="Guardar" actionListener="#{reservacionManejado.actualizarDatos}" disabled="false" reRender="formulario" style="margin-right:348px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarReservacion"/>		
			</a4j:commandButton>
						
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{reservacionManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>