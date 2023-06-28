<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="resultBusqueda">
		<h:outputLabel value="Listado de Personas" styleClass="encabezado" />
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarReservacionesManejado.table}" value="#{listarReservacionesManejado.reservaciones}" var="reservacion" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Numero" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarReservacionesManejado.mostrar}" value="#{reservacion.numeroReservacion}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Reservante" />
					</f:facet>
					
					<h:outputText value="#{reservacion.reservante.nombreCompleto}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Fecha Solicitud" />
					</f:facet>
					
					<h:outputText value="#{reservacion.fechaSolicitud}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Fecha Llegada" />
					</f:facet>
					
					<h:outputText value="#{reservacion.fechaLlegada}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Fecha Partida" />
					</f:facet>
					
					<h:outputText value="#{reservacion.fechaPartida}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Seleccionar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarReservacionesManejado.seleccionar}" value="Seleccionar" status="globalStatus" />
				</h:column>	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
	
	<t:div styleClass="separador_arriba">
		<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{listarReservacionesManejado.cancelar}" disabled="false" />
	</t:div>  
</h:form>