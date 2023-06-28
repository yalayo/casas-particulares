<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://app/component" prefix="app"%>

<a4j:outputPanel id="error" ajaxRendered="true" styleClass="d_MsgPanel">
	<app:messages errorStyleClass="validation-failed" informStyleClass="validation-failed" requiredStyleClass="validation-failed" warnStyleClass="validation-failed" />
</a4j:outputPanel>