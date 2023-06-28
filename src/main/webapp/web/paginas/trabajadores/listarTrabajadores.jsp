<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="form">
	<t:div id="resultBusqueda">
		<h:outputLabel value="Listado de Trabajadores" styleClass="encabezado" />
		<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
			<h:dataTable binding="#{listarTrabajadoresManejado.table}" value="#{listarTrabajadoresManejado.trabajadores}" var="trabajador" rows="10" id="tabla"
				styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
				rowClasses="null,alt">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nombre" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarTrabajadoresManejado.mostrar}" value="#{trabajador.nombreCompleto}" eventsQueue="ubig"
						requestDelay="3" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Edad" />
					</f:facet>
					
					<h:outputText value="#{trabajador.edad}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Sexo" />
					</f:facet>
					
					<h:outputText value="#{trabajador.sexo}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Departamento" />
					</f:facet>
					
					<h:outputText value="#{trabajador.departamento}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Correo" />
					</f:facet>
					
					<h:outputText value="#{trabajador.correo}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Modificar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarTrabajadoresManejado.modificar}" value="Modificar" eventsQueue="not"	requestDelay="1" status="globalStatus" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Eliminar" />
					</f:facet>
					
					<a4j:commandLink immediate="true" actionListener="#{listarTrabajadoresManejado.eliminar}" value="Eliminar" eventsQueue="not"	requestDelay="1" status="globalStatus" />
				</h:column>
	
			</h:dataTable>
	
			<app:dataScroller for="tabla" />
		</h:panelGrid>
	</t:div>
	
	<t:div styleClass="separador_arriba">
		<a4j:commandButton id="aceptar" value="Registrar" actionListener="#{listarTrabajadoresManejado.adicionar}" disabled="false" />
	</t:div>   
</h:form>