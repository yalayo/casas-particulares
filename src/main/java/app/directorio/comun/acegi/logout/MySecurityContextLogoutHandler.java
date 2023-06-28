package app.directorio.comun.acegi.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.ui.logout.LogoutHandler;

import app.directorio.comun.util.ApplicationUtil;

public class MySecurityContextLogoutHandler implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		
		ApplicationUtil.setAuthentication(null);		
	}
}
