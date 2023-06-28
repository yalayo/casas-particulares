<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="criterios" styleClass="separador_arriba">
		<h:outputLabel value="Búsqueda por Criterios" styleClass="encabezado" />
		
		<h:panelGrid id="nomb" columns="2" columnClasses="w50, field_mrg w50" styleClass="tabla_form w100">
			<h:outputText value="Nombre" />
			<h:inputText value="#{listarPersonasManejado.nombre}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
	</t:div>
	
	<t:div id="botones_busqueda" styleClass="separador_arriba">
		<a4j:commandButton id="consultar" value="Buscar" actionListener="#{listarPersonasManejado.consultar}" reRender="resultBusqueda,criterios" disabled="false" />
	</t:div>
	
	<t:div id="resultBusqueda">
		<h:outputLabel value="Listado de Personas" styleClass="encabezado" />
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarPersonasManejado.table}" value="#{listarPersonasManejado.personas}" var="persona" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nombre" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarPersonasManejado.mostrar}" value="#{persona.nombreCompleto}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Carnet" />
					</f:facet>
					
					<h:outputText value="#{persona.carnetIdentidad}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Telefono" />
					</f:facet>
					
					<h:outputText value="#{persona.telefono}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Celular" />
					</f:facet>
					
					<h:outputText value="#{persona.celular}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Modificar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarPersonasManejado.modificar}" value="Modificar" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Eliminar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarPersonasManejado.eliminar}" value="Eliminar" status="globalStatus" reRender="resultBusqueda" />
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
	
	<t:div styleClass="separador_arriba">
		<a4j:commandButton id="aceptar" value="Registrar" actionListener="#{listarPersonasManejado.adicionar}" />
	</t:div>   
</h:form>