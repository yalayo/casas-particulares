package cu.desoft.gtm.sigeml.administracion.seguridad.dao.test;

import java.util.ArrayList;
import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.dao.UsuarioDao;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;
import cu.desoft.gtm.sigeml.core.test.dao.ApplicationDaoTestCase;

public class UsuarioDaoTestCase extends ApplicationDaoTestCase {
	public UsuarioDaoTestCase() {
		List<String> lista = new ArrayList<String>();
		lista.add("classpath:cu/sib/fcba/administracion/seguridad/config/test/applicationContext-dao.xml");
		
		configurar(lista);
	}
	
	public void testSalvar() {
		UsuarioDao usuarioDao = (UsuarioDao)getApplicationContext().getBean("usuarioDao");
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuario("admin");
		usuario.setPassword("admin");
		usuario.setPreguntaSeguridad("Pregunta");
		usuario.setRespuestaSeguridad("Respuesta");
		
		usuarioDao.salvar(usuario);
		
		Usuario temp = (Usuario)usuarioDao.obtenerPorId(usuario.getId(), Usuario.class);
		assertNotNull(temp);
	}
}
