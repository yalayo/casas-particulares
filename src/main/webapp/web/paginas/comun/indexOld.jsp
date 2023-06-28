<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<%@ taglib uri="http://acegisecurity.org/authz" prefix="authz"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Portal</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	
	<link href="../../css/mystyle.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="../../css/principal.css" rel="stylesheet" type="text/css" media="screen" />
	
	<!--[if IE 5]>
    <style type="text/css"> 
    	/* coloque las reparaciones del modelo de cuadro para IE 5* en este comentario condicional */
    	.twoColFixLtHdr #sidebar1 { width: 230px; }
    </style>
    <![endif]-->
    
    <!--[if IE]>    
    <style type="text/css"> 
    	/* coloque las reparaciones de css para todas las versiones de IE en este comentario condicional */
    	.twoColFixLtHdr #sidebar1 { padding-top: 30px; }
    	.twoColFixLtHdr #mainContent { zoom: 1; }
    	/* la propiedad zoom propia que se indica más arriba proporciona a IE el hasLayout que necesita para evitar diversos errores */
    </style>
    <![endif]-->
	
	<script src="../../../faces/cicpc_val/validators.js" type="text/javascript"></script>
	<script src="../../js/panelMenu.js" type="text/javascript"></script>
	<script src="../../js/validation.js" type="text/javascript"></script>
	<script src="../../js/ellipsis.js" type="text/javascript"></script>
	<script src="../../js/tooltip.js" type="text/javascript"></script>
	
	</head>
	
	<body class="twoColFixLtHdr" style="height: 768px;">
		<f:view>
			<div id="container" class="h100">	      			      
	      		<div id="header">        		
	      		</div>
	      		
	      		<div id="logout">        		
	      			<a href="../../../j_acegi_logout">Salir</a>
	      		</div>
	      		
	      		<div id="sidebar1">
	      			<div id="menu">
						<a4j:form id="fMenu">
							<rich:panelMenu id="menuComp" binding="#{applicationBeanManejado.menu}" mode="none" expandSingle="true" style="160px"/>
						</a4j:form>
					</div>
	      		</div>
	      
	      		<div id="mainContent" class="h100">
	      			<div id="d_titulo">						
						<a4j:status id="globalStatus" layout="inline" styleClass="ajaxStatus">
							<f:facet name="start">
								<h:graphicImage value="/web/img/loading.gif" styleClass="d_Loading" />
							</f:facet>
						</a4j:status>
					</div>
					
					<a4j:jsFunction id="jsFuncRefresh" name="updateMessages" reRender="error" data="Data Titulo">
					</a4j:jsFunction> <%@ include file="./error.jsp"%>
															
					<!-- Aqui va el componente a4j:include general de la aplicacion -->
					<h:panelGroup id="actualizarContenido">
						<a4j:include styleClass="clase" id="includeGeneral" binding="#{applicationBeanManejado.include}" viewId="#{applicationBeanManejado.url}" />
					</h:panelGroup>	      			
	      		</div>      		
	   		</div>
	   		
	   		<div id="footer">
	        	<p>
	        		Portal ... 
	        	</p>
	      	</div>
		</f:view>		
	</body>
</html>
