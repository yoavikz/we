package weproject;

import java.time.YearMonth;
import java.util.Date;

import utils.Consts;
import utils.DateUtil;

public class RevenueCalculationAlgorithm {
	public int calculateRevenuePerMonth(String inputDate, String[] dataLine) {
		return (int) (getRelativePartOfMonthForPayment(inputDate, dataLine)
				* Integer.parseInt(dataLine[Consts.MONTHLY_PRICE_INDEX]));
	}

	private float getRelativePartOfMonthForPayment(String inputDate, String[] dataLine) {
		int numOfDaysForPayment = getNumOfPayingDays(inputDate, dataLine);
		System.out.println(numOfDaysForPayment);
		String[] splittedInputDate = inputDate.split("-");
		float relativePart = (float) numOfDaysForPayment / YearMonth.of(Integer.parseInt(splittedInputDate[0]), Integer.parseInt(splittedInputDate[1])).lengthOfMonth();
		return relativePart;
	}

	private int getNumOfPayingDays(String inputDate, String[] dataLine) {
		Date inputDateObject = DateUtil.createDate(inputDate);
		Date startDateObject = DateUtil.createDate(dataLine[Consts.START_DAY_INDEX]);
		int daysInInputMonth = DateUtil.numberOfDaysInMonth(DateUtil.getYear(inputDateObject),
				DateUtil.getMonth(inputDateObject));
		Date endOfInputMonth = DateUtil.createDate(inputDate + "-" + daysInInputMonth);
		Date endDateObject = null;
		if (dataLine.length == 4)
			endDateObject = DateUtil.createDate(dataLine[Consts.END_DAY_INDEX]);
		if (dataLine.length == 3 || endDateObject == null || endDateObject.after(endOfInputMonth))
			endDateObject = endOfInputMonth;

		if (inputDateObject.after(endDateObject))
			return 0;
		if (startDateObject.after(inputDateObject)
				&& (DateUtil.getMonth(startDateObject) > DateUtil.getMonth(inputDateObject)))
			return 0;
		if (startDateObject.after(inputDateObject)
				&& (DateUtil.getMonth(startDateObject) == DateUtil.getMonth(inputDateObject)))
			return DateUtil.daysBetween(startDateObject, endDateObject);
		if (startDateObject.before(inputDateObject) || startDateObject.equals(inputDateObject))
			return DateUtil.getDay(endDateObject);

		return 0;
	}

}
