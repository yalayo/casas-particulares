<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="resultBusqueda">
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarProyectosManejado.table}" value="#{listarProyectosManejado.proyectos}" var="proyecto" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,,,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nombre" />
					</f:facet>
					
					<a4j:commandLink  actionListener="#{listarProyectosManejado.procesar}" value="#{proyecto.nombre}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Descripcion" />
					</f:facet>
					<h:outputText value="#{proyecto.descripcion}" />
					
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
</h:form>