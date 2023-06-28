package app.directorio.comun.util;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.springframework.context.ApplicationContext;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class ApplicationUtil {
	private static ApplicationContext applicationContext;
	private static Authentication authentication;
	
	public ApplicationUtil() {
		
	}
	
	public static List<Permiso> obtenerPermisosUsuario() {
		List<Permiso> lista = new ArrayList<Permiso>();
		
		if(authentication != null) {
			GrantedAuthority[] arr = authentication.getAuthorities();
			
			for (int i = 0; i < arr.length; i++) {
				GrantedAuthority a = arr[i];
				
				Permiso p = new Permiso();
				p.setNombre(a.getAuthority());
				
				lista.add(p);
			}
		}
		
		return lista;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationUtil.applicationContext = applicationContext;
	}

	public static Authentication getAuthentication() {
		return authentication;
	}

	public static void setAuthentication(Authentication authentication) {
		ApplicationUtil.authentication = authentication;
	}
}
