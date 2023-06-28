<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<t:div styleClass="inferior separa_div_abajo">
	<h:outputLabel styleClass="encabezado" value="Datos" />
	<h:panelGrid columns="2" styleClass="tabla_layout w100" columnClasses="w50 separador_der, w50">
			<t:div>
				<h:panelGrid columns="2" styleClass="tabla_datos w100" columnClasses="header,null" rowClasses="null, alt" rendered="true">
					<h:outputText value="Nombre" rendered="true" />
					<h:outputText value="#{mostrarPermisoManejado.permiso.nombre}" rendered="true" />
					<h:outputText value="descripcion" rendered="true" />
					<h:outputText value="#{mostrarPermisoManejado.permiso.descripcion}" rendered="true" />
				</h:panelGrid>
			</t:div>
	</h:panelGrid>

	<h:form>
		<t:div styleClass="botones separa_div_arriba" style="width:100%">
			<a4j:commandButton actionListener="#{mostrarPermisoManejado.aceptar}" immediate="true" value="Aceptar" eventsQueue="ubig" requestDelay="3" />
			<a4j:commandButton actionListener="#{mostrarPermisoManejado.modificar}" rendered="true" immediate="true" value="Modificar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" />
			
		</t:div>
	</h:form>
</t:div>