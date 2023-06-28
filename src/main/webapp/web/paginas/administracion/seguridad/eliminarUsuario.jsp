<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">
	<t:div id="modificarUsuario" styleClass="w100">
	
		<h:outputLabel value="Datos" styleClass="encabezado" />
		
		<h:panelGrid columns="2" columnClasses="alTop,separadorDerecha alTop" styleClass="w100">
			<h:panelGrid columns="2" columnClasses="alRight,separadorDerecha">
				<h:outputText value="Usuario" rendered="true" />
				<h:outputText value="#{eliminarUsuarioManejado.usuario.usuario}" rendered="true" />
			    <h:outputText value="Fecha de creacion" rendered="true" />
				<h:outputText value="#{eliminarUsuarioManejado.usuario.fechaCreacion}" rendered="true" />
			    <h:outputText value="Estado" rendered="true" />
				<h:outputText value="#{eliminarUsuarioManejado.usuario.estado}" rendered="true" />
			</h:panelGrid>
		</h:panelGrid>	
		<t:div styleClass="botones separa_div_arriba" style="width:100%">
			<a4j:commandButton actionListener="#{eliminarUsuarioManejado.eliminar}" immediate="true" value="Eliminar" eventsQueue="ubig" requestDelay="3" />
			<a4j:commandButton actionListener="#{eliminarUsuarioManejado.cancelar}" rendered="true" immediate="true" value="Cancelar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" />
			</t:div>
	</t:div>
</h:form>