package app.directorio.comun.acegi.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;

import app.directorio.comun.util.ApplicationUtil;

public class MyAuthenticationProcessingFilter extends AuthenticationProcessingFilter {

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, Authentication authResult)
			throws IOException {

		ApplicationUtil.setAuthentication(authResult);
		
		super.successfulAuthentication(request, response, authResult);
	}
}
