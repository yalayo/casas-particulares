<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="resultBusqueda">
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarPerfilManejado.table}" value="#{listarPerfilManejado.perfiles}" var="perfil" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,,,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nombre" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarPerfilManejado.mostrar}" value="#{perfil.nombre}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
	
				<h:column>
						<f:facet name="header">
							<h:outputText value="Modificar" />
						</f:facet>
						
						<a4j:commandLink immediate="true" actionListener="#{listarPerfilManejado.modificar}" value="Modificar" eventsQueue="not"	requestDelay="1" status="globalStatus" />
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
	
	<t:div styleClass="separador_arriba">
		<a4j:commandButton id="registrar" value="Registrar" actionListener="#{listarPerfilManejado.adicionar}" disabled="false" style="margin-right:10px;"/>
		<a4j:commandButton id="gestionar" value="Permisos" actionListener="#{listarPerfilManejado.gestionarPermisos}" disabled="false" />
	</t:div>
</h:form>