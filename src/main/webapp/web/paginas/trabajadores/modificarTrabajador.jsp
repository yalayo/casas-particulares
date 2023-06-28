<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="modificarNoticia" styleClass="w100">            
		<h:outputLabel value="Trabajador" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">			
			<h:panelGrid columns="1" columnClasses="w50, field_mrg w50" styleClass="tabla_form w100">
				<h:outputLabel value="Nombre" for="nombre"/>
				<h:inputText id="nombre" value="#{modificarTrabajadorManejado.trabajador.nombre}" styleClass="required val-nombre w100" />
				
				<h:outputLabel value="Apellidos" for="apellidos"/>
				<h:inputText id="apellidos" value="#{modificarTrabajadorManejado.trabajador.apellidos}" styleClass="required val-nombre w100"/> 
				
				<h:outputLabel value="Edad" for="edad"/>
				<h:inputText id="edad" value="#{modificarTrabajadorManejado.trabajador.edad}" styleClass="required w100"/>
				
				<h:outputLabel value="Sexo" for="sexo"/>
				<h:selectOneMenu id="sexo" value="#{modificarTrabajadorManejado.trabajador.sexo}">
                    <f:selectItem itemValue="M" itemLabel="Masculino"/>
                    <f:selectItem itemValue="F" itemLabel="Femenino"/>
                </h:selectOneMenu>
                
                <h:outputLabel value="Departamento" for="dep"/>  	    
			    <h:selectOneMenu id="dep" value="#{modificarTrabajadorManejado.trabajador.departamento}" styleClass="label w100">
					<f:selectItems value="#{modificarTrabajadorManejado.departamentos}" />
					<f:converter converterId="selectItemsListConvertidor" />
				</h:selectOneMenu>
				
				<h:outputLabel value="Cargo" for="car"/>  	    
			    <h:selectOneMenu id="car" value="#{modificarTrabajadorManejado.trabajador.cargo}" styleClass="label w100">
					<f:selectItems value="#{modificarTrabajadorManejado.cargos}" />
					<f:converter converterId="selectItemsListConvertidor" />
				</h:selectOneMenu>
				
				<h:outputLabel value="Correo" for="correo"/>
				<h:inputText id="correo" value="#{modificarTrabajadorManejado.trabajador.correo}" styleClass="required validate-email w100"/>
			</h:panelGrid>
		</t:div>
		
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{modificarTrabajadorManejado.modificar}" disabled="false" reRender="formulario">
				<app:validationConfigurationGenerator id="validator" for="modificarNoticia"/>		
			</a4j:commandButton>
		</t:div>                
	</t:div>
</h:form>