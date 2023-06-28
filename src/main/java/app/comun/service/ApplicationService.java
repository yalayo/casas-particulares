package app.comun.service;

import java.util.List;

public interface ApplicationService {
	public void salvar(Object object);
	public void actualizar(Object object);
	public void eliminar(Object object) throws Exception;
	public Object obtenerPorId(Integer id, Class<?> clazz);
	public List<?> obtenerTodos(Class<?> clazz);
}
