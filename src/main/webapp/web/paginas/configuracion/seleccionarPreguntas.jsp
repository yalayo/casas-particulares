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
			<h:inputText value="#{seleccionarPreguntasManejado.nombre}" styleClass="grupoConsultar w100" maxlength="200"/>
		</h:panelGrid>
	</t:div>
	
	<t:div id="botones_busqueda" styleClass="separador_arriba">
		<a4j:commandButton id="consultar" value="Buscar" actionListener="#{seleccionarPreguntasManejado.consultar}" reRender="resultBusqueda,criterios" disabled="false" />
	</t:div>
	
	<t:div id="resultBusqueda">
		<h:outputLabel value="Listado de Preguntas" styleClass="encabezado" />
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{seleccionarPreguntasManejado.table}" value="#{seleccionarPreguntasManejado.preguntas}" var="preg" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Numero" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{seleccionarPreguntasManejado.mostrar}" value="#{preg.numero}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Texto" />
					</f:facet>
					
					<h:outputText value="#{preg.texto}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Accion" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{seleccionarPreguntasManejado.seleccionar}" value="Seleccionar" reRender="resultBusqueda" status="globalStatus" />
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
		
		<a4j:commandLink immediate="true" actionListener="#{seleccionarPreguntasManejado.filtrar}" value="#{seleccionarPreguntasManejado.datosCriterios}" />
	</t:div> 
</h:form>