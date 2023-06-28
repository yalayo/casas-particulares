package app.core.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static int ultimoDiaMes(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		int mes = calendar.get(Calendar.MONTH);
		
		switch (mes) {
			case 0: 
				return 31;
				
		}
		
		return -1;
	}
}
