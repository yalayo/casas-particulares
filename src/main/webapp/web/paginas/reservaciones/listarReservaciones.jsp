<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="criterios" styleClass="separador_arriba">
		<h:outputLabel value="Búsqueda por Criterios" styleClass="encabezado" />
		
		<h:panelGrid id="nomb" columns="2" columnClasses="w50, field_mrg w50" styleClass="w100">
			<h:outputText value="Nombre" />
			<h:inputText value="#{listarReservacionesManejado.nombre}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
		
		<h:panelGrid id="num" columns="2" columnClasses="w50, field_mrg w50" styleClass="w100">
			<h:outputText value="Numero" />
			<h:inputText value="#{listarReservacionesManejado.numero}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
		
		<h:panelGrid id="numResCub" columns="2" columnClasses="w50, field_mrg w50" styleClass="w100">
			<h:outputText value="Numero Reserva Cubanacan" />
			<h:inputText value="#{listarReservacionesManejado.numeroReservaCubanacan}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
		
		<h:panelGrid id="numResCt" columns="2" columnClasses="w50, field_mrg w50" styleClass="w100">
			<h:outputText value="Numero Reserva Cubatur" />
			<h:inputText value="#{listarReservacionesManejado.numeroReservaCubatur}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
	</t:div>
	
	<t:div id="botones_busqueda" styleClass="separador_arriba">
		<a4j:commandButton id="consultar" value="Buscar" actionListener="#{listarReservacionesManejado.consultar}" reRender="resultBusqueda,criterios" disabled="false" />
	</t:div>
	
	<t:div id="resultBusqueda">
		<h:outputLabel value="Listado de Reservaciones" styleClass="encabezado" />
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarReservacionesManejado.table}" value="#{listarReservacionesManejado.reservaciones}" var="reservacion" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Numero" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarReservacionesManejado.mostrar}" value="#{reservacion.numeroReservacion}" status="globalStatus" />
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
						<h:outputText value="Modificar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarReservacionesManejado.modificar}" value="Modificar" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Eliminar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarReservacionesManejado.eliminar}" value="Eliminar" status="globalStatus" reRender="resultBusqueda"/>
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
	
	<t:div styleClass="separador_arriba">
		<a4j:commandButton id="aceptar" value="Registrar" actionListener="#{listarReservacionesManejado.adicionar}" disabled="false" />
	</t:div>   
</h:form>