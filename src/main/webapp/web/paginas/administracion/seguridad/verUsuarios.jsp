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
					<h:outputText value="Usuario" rendered="true" />
					<h:outputText value="#{mostrarUsuarioManejado.usuario.usuario}" rendered="true" />
					<h:outputText value="Pregunta de Seguridad" rendered="true" />
					<h:outputText value="#{mostrarUsuarioManejado.usuario.preguntaSeguridad}" rendered="true" />
					<h:outputText value="Respuesta de Seguridad" rendered="true" />
					<h:outputText value="#{mostrarUsuarioManejado.usuario.respuestaSeguridad}" rendered="true" />
					<h:outputText value="Fecha de creacion " rendered="true" />
					<h:outputText value="#{mostrarUsuarioManejado.usuario.fechaCreacion}" rendered="true" />
					<h:outputText value="Estado" rendered="true" />
					<h:outputText value="#{mostrarUsuarioManejado.usuario.estado}" rendered="true" />
				</h:panelGrid>
			</t:div>
	</h:panelGrid>

	<h:form>
		<t:div styleClass="botones separa_div_arriba" style="width:100%">
			<a4j:commandButton actionListener="#{mostrarUsuarioManejado.aceptar}" immediate="true" value="Aceptar" eventsQueue="ubig" requestDelay="3" reRender="formulario"/>
			<a4j:commandButton actionListener="#{mostrarUsuarioManejado.modificar}"  immediate="true" value="Modificar" style="margin-left:10px" eventsQueue="ubig" requestDelay="3" reRender="formulario" />
			
		</t:div>
	</h:form>
</t:div>