<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Pluralism
Description: A two-column, fixed-width template fit for 1024x768 screen resolutions.
Version    : 1.0
Released   : 20071218

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Directorio de Arrendatarios</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

	<script type='text/javascript' src='../faces/a4j_3_1_6.GAorg.ajax4jsf.javascript.PrototypeScript'></script>
	
	<!-- JS de la aplicacion -->
	<script type='text/javascript' src='js/application.js'></script>
	
	<!-- Para JSF -->
	<script src="js/validation.js" type="text/javascript"></script>
	<script src="../faces/cicpc_val/validators.js" type="text/javascript"></script>
	<script src="js/panelMenu.js" type="text/javascript"></script>
	
	<script src="js/ellipsis.js" type="text/javascript"></script>
	<script src="js/tooltip.js" type="text/javascript"></script>
		
	<link href="css/mystyle.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="css/principal.css" rel="stylesheet" type="text/css" media="screen" />
	
	<!-- Para DWR -->
    <script type='text/javascript' src='../dwr/engine.js'></script>
	<script type='text/javascript' src='../dwr/util.js'></script>
    
    <!-- Para DWR llamar a los metodos (Especifico del programador) 
	<script type='text/javascript' src='../dwr/interface/authenticator.js'></script>
	<script type='text/javascript' src='../dwr/interface/noticiaController.js'></script>
	<script type='text/javascript' src='../dwr/interface/elementoController.js'></script> -->
    
	
	<!-- JS de la aplicacion -->
	<script type='text/javascript' src='js/application.js'></script>
</head>

<body>
<f:view>
<a4j:form id="ajaxform">
<div id="wrapper">
	<div id="wrapper2">
		<div id="header">
			<div id="logo">
				
			</div>
						
			<div id="menu">
				<ul>										
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verReservaciones}" value="Reservaciones" rendered="#{applicationManejado.opcionReservacion}" status="globalStatus" /></a></li>
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verPersonas}" value="Personas" rendered="#{applicationManejado.opcionPersona}" status="globalStatus" /></li>
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verArrendatarios}" value="Arrendatarios" rendered="#{applicationManejado.opcionArrendatario}" status="globalStatus" /></li>
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verProductos}" value="Productos" rendered="#{applicationManejado.opcionProducto}" status="globalStatus" /></li>
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verTrabajadores}" value="Trabajadores" rendered="false" status="globalStatus" /></li>
					<li><a4j:commandLink immediate="true" actionListener="#{applicationManejado.verUsuarios}" value="Usuarios" rendered="#{applicationManejado.opcionUsuario}" status="globalStatus" /></li>
					<li><a href="../j_acegi_logout">Salir</a></li>
				</ul>
			</div>
			
			
		</div>
		<!-- end #header -->
		<div id="page">
			
			<div id="sidebar">
				<ul>
					<li id="opts">
						<h3>Otras opciones</h3>
						
						<ul>
							<li><a4j:commandLink  actionListener="#{applicationManejado.verNomencladores}" value="Nomencladores" rendered="#{applicationManejado.opcionNomenclador}" status="globalStatus"  /></li>
							<li><a4j:commandLink  actionListener="#{applicationManejado.verPreguntas}" value="Preguntas" rendered="#{applicationManejado.opcionPregunta}" status="globalStatus"  /></li>
							<li><a4j:commandLink  actionListener="#{applicationManejado.buscarCasas}" value="Busqueda" rendered="#{applicationManejado.opcionBusqueda}" status="globalStatus"  /></li>
							<li><a4j:commandLink  actionListener="#{applicationManejado.reservacionesMes}" value="Reservaciones del Mes" rendered="#{applicationManejado.opcionBusqueda}" status="globalStatus"  /></li>
						</ul>
					</li>
					
					<li>
						
					</li>

					<li id="docs">
						
					</li>
				</ul>
			</div>
			<!-- end #sidebar -->
								
			</a4j:form>
			<div id="content">				
				<div id="d_titulo">						
					<a4j:status id="globalStatus" layout="inline" styleClass="ajaxStatus">
						<f:facet name="start">
							<h:graphicImage value="/web/img/loading.gif" styleClass="d_Loading" />
						</f:facet>
					</a4j:status>
				</div>
				
				<a4j:jsFunction id="jsFuncRefresh" name="updateMessages" reRender="error" data="Data Titulo">
				</a4j:jsFunction> 

				<%@ include file="./error.jsp"%>
														
				<!-- Aqui va el componente a4j:include general de la aplicacion -->
				<h:panelGroup id="actualizarContenido">
					<a4j:include styleClass="clase" id="includeGeneral" binding="#{applicationBeanManejado.include}" viewId="#{applicationBeanManejado.url}" />
				</h:panelGroup>	
			</div>
			<!-- end #content -->	
			
			<div style="clear: both;">&nbsp;</div>
			<div id="widebar">
				<div id="colA">
					
				</div>
				<div id="colB">
					
				</div>
				
				<div style="clear: both;">&nbsp;</div>
			</div>
			<!-- end #widebar -->
			
		<!-- end #page -->
	</div>
	<!-- end #wrapper2 -->
	<div id="footer">
		<p>(c) 2012 Directorio de Arrendatarios. Design by <a href="#"> </a></p>
	</div>
</div>
<!-- end #wrapper -->

</f:view>
</body>
</html>
