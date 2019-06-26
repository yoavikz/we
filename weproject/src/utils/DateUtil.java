package utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date createDate(String stringDate) {
		String[] dateSplitted = stringDate.split("-");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(dateSplitted[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateSplitted[1]) - 1);
		if (dateSplitted.length == 2) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
		} else if (dateSplitted.length == 3) {
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateSplitted[2]));
		}
		Date dateRepresentation = cal.getTime();
		return dateRepresentation;
	}

	public static int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static int numberOfDaysInMonth(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}

	public static int getMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getMonthValue();
	}

	public static int getDay(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getDayOfMonth();
	}
	
	public static int getYear(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getYear();
	}

}
