package cu.desoft.gtm.sigeml.administracion.seguridad.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.UsuarioService;

import junit.framework.TestCase;

public class UsuarioServiceTestCase extends TestCase {
	private ApplicationContext applicationContext;
	
	public UsuarioServiceTestCase() {
		applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:cu/sib/fcba/administracion/seguridad/config/test/applicationContext-service.xml"
																			 });
	}
	
	public void testPrimeraPrueba() {
		UsuarioService usuarioService = (UsuarioService)applicationContext.getBean("usuarioService");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("usuario");
		
		usuarioService.incluirUsuario(usuario);
	}
}
