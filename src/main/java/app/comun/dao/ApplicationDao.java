package app.comun.dao;

import java.util.List;

public interface ApplicationDao {
	public void salvar(Object object);
	public void actualizar(Object object);
	public void eliminar(Object object) throws Exception;
	public Object obtenerPorId(Integer id, Class<?> clazz);
	public List<?> obtenerTodos(Class<?> clazz);
}
