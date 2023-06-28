package app.directorio.comun.web.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.component.UIComponent;

import app.comun.service.ApplicationService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class ApplicationBaseBean extends BaseBean {
	private ApplicationService applicationService;
	
	private UIComponent bind;
	
	public ApplicationBaseBean() {
		super();
	}

	public ApplicationService getApplicationService() {
		if(applicationService == null)
			applicationService = (ApplicationService)getBeanValue("applicationService");
		
		return applicationService;
	}
	
	public UIComponent getBind() {
		return bind;
	}

	public void setBind(UIComponent bind) {
		this.bind = bind;
	}

	public void salvar(Object object) {
		getApplicationService().salvar(object);
	}
	
	public void actualizar(Object object) {
		getApplicationService().actualizar(object);
	}
	
	public void eliminar(Object object) throws Exception {		
		getApplicationService().eliminar(object);
	}

	public Object obtenerPorId(Integer id, Class<?> clazz) {
		return getApplicationService().obtenerPorId(id, clazz);
	}

	public List<?> obtenerTodos(Class<?> clazz) {
		return getApplicationService().obtenerTodos(clazz);
	}
	
	public void relacionar(Object contenedor, Object object, String metodo) {
		try {
            Method method = contenedor.getClass().getMethod(metodo , new Class[]{object.getClass()});
            method.invoke(contenedor, new Object[]{object});
            
            actualizar(contenedor);
        }

        catch (NoSuchMethodException ex) {
            System.out.println(ex.getMessage());
            System.out.println("No existe el setter");
        } 
        
        catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
        
        catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
        
        catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/*public void getValue(String identificador) {
		bind.get
		
		//TODO Iterar por lo componentes y buscar el valor a mostrar en los ficheros .properties
	}*/
}
