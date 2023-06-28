<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<h:form id="formulario">    
	<t:div id="adicionarTrabajador" styleClass="w100">            
		<h:outputLabel value="Trabajador" styleClass="encabezado" />
		
		<h:panelGrid columns="2" styleClass="tabla_layout w100" columnClasses="w50, separador_izq w50">			
			<h:panelGrid columns="1" columnClasses="w50, field_mrg w50" styleClass="tabla_form w100">
				<h:outputLabel value="Nombre" for="nombre"/>
				<h:inputText id="nombre" value="#{trabajadorManejado.nombre}" styleClass="required val-nombre w100" />
				
				<h:outputLabel value="Apellidos" for="apellidos"/>
				<h:inputText id="apellidos" value="#{trabajadorManejado.apellidos}" styleClass="required val-nombre w100"/> 
				
				<h:outputLabel value="Edad" for="edad"/>
				<h:inputText id="edad" value="#{trabajadorManejado.edad}" styleClass="required w100"/>
				
				<h:outputLabel value="Sexo" for="sexo"/>
				<h:selectOneMenu id="sexo" value="#{trabajadorManejado.sexo}">
                    <f:selectItem itemValue="M" itemLabel="Masculino"/>
                    <f:selectItem itemValue="F" itemLabel="Femenino"/>
                </h:selectOneMenu>
                
                <h:outputLabel value="Departamento" for="dep"/>  	    
			    <h:selectOneMenu id="dep" value="#{trabajadorManejado.departamento}" styleClass="label w100">
					<f:selectItems value="#{trabajadorManejado.departamentos}" />
					<f:converter converterId="selectItemsListConvertidor" />
				</h:selectOneMenu>
				
				<h:outputLabel value="Cargo" for="car"/>  	    
			    <h:selectOneMenu id="car" value="#{trabajadorManejado.cargo}" styleClass="label w100">
					<f:selectItems value="#{trabajadorManejado.cargos}" />
					<f:converter converterId="selectItemsListConvertidor" />
				</h:selectOneMenu>
				
				<h:outputLabel value="Correo" for="correo"/>
				<h:inputText id="correo" value="#{trabajadorManejado.correo}" styleClass="required validate-email w100"/>
			</h:panelGrid>			
			
			<h:panelGrid columns="1" columnClasses="w100" styleClass="tabla_form w100">
				<h:outputLabel value="ID Usuario" for="idUsuario"/>
				<h:inputText id="idUsuario" value="#{trabajadorManejado.usuario}" styleClass="required w100" />
				
				<h:outputLabel value="Contraseña" for="cont"/>
				<h:inputSecret id="cont" value="#{trabajadorManejado.password}" styleClass="required w100" />
				
				<h:outputLabel value="Confirmación" for="confirmacion"/>
				<h:inputSecret id="confirmacion" value="#{trabajadorManejado.confirmacion}" styleClass="required w100" maxlength="40" />
			</h:panelGrid>
		</h:panelGrid>
		
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{trabajadorManejado.adicionar}" disabled="false" reRender="formulario">
				<app:validationConfigurationGenerator id="validator" for="adicionarTrabajador"/>		
			</a4j:commandButton>
		</t:div>                
	</t:div>
</h:form>