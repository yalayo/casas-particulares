<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>


<h:form id="formulario">    
	<t:div id="adicionarProducto" styleClass="w100">            
		<h:outputLabel value="Producto" styleClass="encabezado" />
		
		<t:div id="content" styleClass="w100">
			<h:panelGrid id="datos" columns="2" columnClasses="w50, w50" styleClass="w100">
				<h:outputLabel value="Nombre" for="nombre"/>				
				<h:inputText id="nombre" value="#{productoManejado.producto.nombre}" styleClass="val-nombre required w100 float_right" />
				
				<h:outputLabel value="Codigo" for="codigo"/>				
				<h:inputText id="codigo" value="#{productoManejado.producto.codigo}" styleClass="val-numReserva required w100 float_right" />
								
				<h:outputLabel value="Cantidad de Dias" for="cantidadDias"/>				
				<h:inputText id="cantidadDias" value="#{productoManejado.producto.cantidadDias}" styleClass="validate-digits w100 float_right" />
								
				<h:outputLabel value="Fecha Inicio" for="fechaIni"/>	
				<rich:calendar id="fechaIni" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="float_right" value="#{productoManejado.producto.fechaInicio}" >
					<app:dateRangeValidator type="belowToday" />
				</rich:calendar>
				
				<h:outputLabel value="Fecha Fin" for="fechaFin"/>
				<rich:calendar id="fechaFin" datePattern="dd/MM/yyyy" inputClass="val-consultar" styleClass="float_right" value="#{productoManejado.producto.fechaFin}" >
					<app:dateRangeValidator type="aboveStart" startDateId="fechaIni"/>
				</rich:calendar>
			</h:panelGrid>
		</t:div>
					
							
		<t:div styleClass="separador_arriba">
			<a4j:commandButton id="aceptar" value="Aceptar" actionListener="#{productoManejado.registrarDatos}" disabled="false" reRender="formulario" style="margin-right:10px;">
				<app:validationConfigurationGenerator id="validatorAceptar" for="adicionarProducto"/>		
			</a4j:commandButton>
			
			<a4j:commandButton id="cancelar" value="Cancelar" actionListener="#{productoManejado.cancelar}" disabled="false" />
		</t:div>                
	</t:div>
</h:form>