<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="formulario">
	<t:div id="modificarPerfil" styleClass="w100">
		<h:outputLabel value="Datos" styleClass="encabezado" />
		
		<h:panelGrid columns="2" styleClass="tabla_layout w100" columnClasses="w50, separador_izq w50">
			<t:div>
				<h:outputLabel value="Nombre" for="nombre"/>
				<h:inputText id="nombre" value="#{modificarPerfilManejado.perfil.nombre}" styleClass="required"/>
			</t:div>
			
			<t:div>
				<h:dataTable var="per" value="#{modificarPerfilManejado.permisos}" id="permisos" rendered="true" rows="7" styleClass="w100 tabla_lista" rowClasses="alLeft,alt" >
					<h:column>
						<f:facet name="header">
							<h:outputText value="Permisos" />
						</f:facet>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<a4j:region id="regionSubmitChangePermiso">
								<h:selectBooleanCheckbox value="#{per.seleccionado}" styleClass="checkbox">
									<a4j:support event="onclick" id="supportRegionSubmit" />
								</h:selectBooleanCheckbox>
							</a4j:region>
							<h:outputText value="#{per.nombre}" />
						</h:panelGrid>
					</h:column>					
				</h:dataTable>	
				
				<app:dataScroller for="permisos"/>
			</t:div>			
		</h:panelGrid>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="modificar" value="Modificar" actionListener="#{modificarPerfilManejado.modificar}" disabled="false" reRender="formulario">
				<app:validationConfigurationGenerator id="validator" for="modificarPerfil"/>		
			</a4j:commandButton>
			
			<a4j:commandButton actionListener="#{modificarPerfilManejado.cancelar}" immediate="true" value="Cancelar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" reRender="formulario"/>
		</t:div>
	</t:div>
</h:form>