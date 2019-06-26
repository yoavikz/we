package logics;

import java.util.Date;
import utils.Consts;
import utils.DateUtil;

public class AlgorithmUtil {

	// This method is common for both algorithms, it returns the amount of days
	// which should be billed in a month
	public static int calculateNumOfPayingDays(String inputDate, String[] dataRow) {
		Date inputDateObject = DateUtil.createDateObject(inputDate);
		Date startDateObject = DateUtil.createDateObject(dataRow[Consts.START_DAY_INDEX]);
		int numOfDaysInInputMonth = DateUtil.numberOfDaysInMonth(DateUtil.getYear(inputDateObject),
				DateUtil.getMonth(inputDateObject));
		Date lastDayOfInputMonth = DateUtil.createDateObject(inputDate + "-" + numOfDaysInInputMonth);
		Date endDateObject = null;
		if (dataRow.length == 4)
			endDateObject = DateUtil.createDateObject(dataRow[Consts.END_DAY_INDEX]);
		if (dataRow.length == 3 || endDateObject == null || endDateObject.after(lastDayOfInputMonth))
			endDateObject = lastDayOfInputMonth;

		// The logic of paymant days calculation
		if (inputDateObject.after(endDateObject))
			return 0;
		if (startDateObject.after(inputDateObject)
				&& (DateUtil.getMonth(startDateObject) > DateUtil.getMonth(inputDateObject)))
			return 0;
		if ((DateUtil.getDay(startDateObject) >= DateUtil.getDay(inputDateObject))
				&& (DateUtil.getMonth(startDateObject) == DateUtil.getMonth(inputDateObject))
				&& (DateUtil.getYear(startDateObject) == DateUtil.getYear(inputDateObject)))
			return DateUtil.getDay(endDateObject) - DateUtil.getDay(startDateObject) + 1;
		if (startDateObject.before(inputDateObject) || startDateObject.equals(inputDateObject))
			return DateUtil.getDay(endDateObject);

		return 0;
	}
}
