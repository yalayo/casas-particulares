<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>
 
<t:div id="respuestaEspecifica" styleClass="w100">        			
	<t:div>	
		<h:panelGrid id="respSimple" columns="2" columnClasses="w50, w50" styleClass="w100" rendered="#{criterioManejado.respuestaSimple}">
			<h:outputLabel value="Respuesta" for="respS"/>				
			<h:inputText id="respS" value="#{criterioManejado.respuesta}" styleClass="required w100 float_right" />
		</h:panelGrid>
		
		<h:panelGrid id="respCompuesta" columns="1" columnClasses="w50, w50" styleClass="w100" rendered="#{not criterioManejado.respuestaSimple}">				
			<h:outputLabel value="Respuesta" for="respComp"/>				
			<h:inputTextarea id="respComp" value="#{criterioManejado.respuesta}" styleClass="required w100 float_right" />
		</h:panelGrid>
	</t:div>                
</t:div>
