<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>
 
<t:div id="respuestaSeleccion" styleClass="w100">        			
	<t:div>							
		<h:panelGrid id="preguntaSeleccion" columns="2" columnClasses="w50, w50" styleClass="w100">
			<h:outputLabel value="Respuesta" />
			<h:selectOneMenu id="dep" value="#{datoManejado.respuestaSeleccion}" styleClass="label w100">
				<f:selectItems value="#{datoManejado.elementos}" />
				<f:converter converterId="selectItemsListConvertidor" />
			</h:selectOneMenu>
		</h:panelGrid>
	</t:div>                
</t:div>
