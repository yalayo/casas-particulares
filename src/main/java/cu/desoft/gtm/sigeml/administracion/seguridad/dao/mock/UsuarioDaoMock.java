package cu.desoft.gtm.sigeml.administracion.seguridad.dao.mock;

import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import cu.desoft.gtm.sigeml.administracion.seguridad.dao.UsuarioDao;

public class UsuarioDaoMock extends MockObjectTestCase implements UsuarioDao {
	private Mock mock;
		
	public UsuarioDaoMock() {
		mock = new Mock(UsuarioDao.class);
	}
	
	public void salvar(Object object) {
		mock.expects(once()).method("salvar").isVoid();
		mock.verify();
	}

	public void actualizar(Object object) {
		mock.reset();
		mock.expects(once()).method("actualizar").isVoid();
		mock.verify();
	}

	public void eliminar(Object object) {
		
	}

	
	public Object obtenerPorId(Integer id, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> obtenerTodos(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
}
