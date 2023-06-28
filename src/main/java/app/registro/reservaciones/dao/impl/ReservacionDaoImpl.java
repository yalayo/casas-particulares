package app.registro.reservaciones.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import app.comun.dao.impl.ApplicationDaoHib;
import app.registro.reservaciones.dao.ReservacionDao;
import app.registro.reservaciones.domain.Reservacion;

public class ReservacionDaoImpl extends ApplicationDaoHib implements ReservacionDao {
	
	public List<Reservacion> obtenerReservaciones(Date fecha) {
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(fecha);
		inicio.set(Calendar.DATE, 0);
		
		
		Calendar fin = Calendar.getInstance();
		fin.setTime(fecha);
		int diaFin = fin.getActualMaximum(Calendar.DAY_OF_MONTH);
		fin.set(Calendar.DATE, diaFin);
				
		Criteria criteria = session.createCriteria(Reservacion.class)
									.add(Expression.between("fechaLlegada", inicio.getTime(), fin.getTime()));
				
		reservaciones.addAll(criteria.list());
		session.close();
		
		return reservaciones;
	}
	
	public List<Reservacion> obtenerReservacionesDisponibles(Date fecha) {
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(fecha);
		inicio.set(Calendar.DATE, 0);
		
		
		Calendar fin = Calendar.getInstance();
		fin.setTime(fecha);
		int diaFin = fin.getActualMaximum(Calendar.DAY_OF_MONTH);
		fin.set(Calendar.DATE, diaFin);
				
		Criteria criteria = session.createCriteria(Reservacion.class)
									.add(Expression.between("fechaLlegada", inicio.getTime(), fin.getTime()))
									.add(Expression.isNull("casa"));
		
		reservaciones.addAll(criteria.list());
		session.close();
		
		return reservaciones;		
	}
	
	public List<Reservacion> obtenerReservacionesAsignadas() {
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
				
		Criteria criteria = session.createCriteria(Reservacion.class)
									.add(Expression.isNotNull("casa"));
		
		reservaciones.addAll(criteria.list());
		session.close();
		
		return reservaciones;	
	}
}
