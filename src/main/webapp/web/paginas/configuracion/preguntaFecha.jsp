<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>
 
<t:div id="respuestaFecha" styleClass="w100">        			
	<t:div>							
		<h:panelGrid id="preguntaFecha" columns="2" columnClasses="w50, w50" styleClass="w100">
			<h:outputLabel value="Respuesta" for="fecha"/>	
			<rich:calendar id="fecha" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="float_right" value="#{datoManejado.respuestaFecha}" />	
		</h:panelGrid>
	</t:div>                
</t:div>
