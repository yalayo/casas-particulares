<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarResp" styleClass="w100">		
		<t:div id="content" styleClass="w100">			
			<h:panelGrid id="numeroPreg" columns="3" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Posible Respuesta" for="valor"/>				
				<h:inputText id="valor" value="#{preguntaManejado.respuesta}" styleClass="required w100 float_right" />
			
				<a4j:commandButton id="registrar" value="Registrar" actionListener="#{preguntaManejado.registrarPosibleRespuesta}" disabled="false" reRender="content">
					<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarResp"/>		
				</a4j:commandButton>
			</h:panelGrid>	
			
			<t:div id="respuestas">
				<h:outputLabel value="Listado de Posibles Respuestas" styleClass="encabezado" />
				<h:panelGrid id="panel" columns="1" styleClass="w100" columnClasses="null, alt"	rendered="true">
					<h:dataTable binding="#{preguntaManejado.table}" value="#{preguntaManejado.respuestas}" var="val" rows="10" id="tabla"
						styleClass="w100 tabla_lista" columnClasses=",,wsmall,wsmall"
						rowClasses="null,alt">
						
						<h:column>
							<f:facet name="header">
								<h:outputText value="Respuesta" />
							</f:facet>
							
							<a4j:commandLink immediate="true" actionListener="" value="#{val.value}" eventsQueue="ubig"
								requestDelay="3" status="globalStatus" />
						</h:column>
						
						<h:column>
							<f:facet name="header">
								<h:outputText value="Eliminar" />
							</f:facet>
							
							<a4j:commandLink immediate="true" actionListener="#{preguntaManejado.eliminarRespuesta}" value="Eliminar" reRender="resultBusqueda" status="globalStatus" />
						</h:column>
			
					</h:dataTable>
			
					<app:dataScroller for="tabla" />
				</h:panelGrid>
			</t:div>	
		</t:div>
				
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{preguntaManejado.cancelar}" disabled="false" reRender="formulario" style="margin-right:425px;" />
						
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{preguntaManejado.cancelar}" />
		</t:div>                
	</t:div>
</h:form>