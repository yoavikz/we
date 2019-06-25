package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date createDate(String stringDateNoDay)
	{
		String[] dateSplitted = stringDateNoDay.split("-");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(dateSplitted[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateSplitted[1]));
		if (dateSplitted.length == 2 )
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		else if (dateSplitted.length == 3)
		{
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateSplitted[2]));
		}
		Date dateRepresentation = cal.getTime();
		return dateRepresentation;
	}
	
}
