<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">
	<t:div id="modificarPermiso" styleClass="w100">
		<h:outputLabel value="Datos" styleClass="encabezado" />
		
		<h:panelGrid columns="2" columnClasses="alTop,separadorDerecha alTop" styleClass="w100">
			
			<h:panelGrid columns="2" columnClasses="alRight,separadorDerecha">
				<h:outputLabel value="Nombre" for="nombre"/>
				<h:inputText id="nombre" value="#{modificarPermisoManejado.permiso.nombre}" styleClass="required" maxlength="18" />
			</h:panelGrid>
			
			<h:panelGrid columns="2" columnClasses="alRight,separadorDerecha">
				<h:outputLabel value="Descripcion" for="descripcion"/>
				<h:inputText id="descripcion" value="#{modificarPermisoManejado.permiso.descripcion}" styleClass="required" maxlength="18" />
			</h:panelGrid>
		</h:panelGrid>
		
		
		<t:div>
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{modificarPermisoManejado.modificar}" disabled="false" reRender="formulario">
				<app:validationConfigurationGenerator id="validator" for="modificarPermiso"/>		
			</a4j:commandButton>
			<a4j:commandButton actionListener="#{modificarPermisoManejado.cancelar}" immediate="true" value="Cancelar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" reRender="formulario"/>
		</t:div>
	</t:div>
</h:form>