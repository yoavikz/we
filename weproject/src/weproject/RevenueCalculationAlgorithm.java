package weproject;

import java.time.YearMonth;
import java.util.Date;

import utils.Consts;
import utils.DateUtil;

public class RevenueCalculationAlgorithm {
	//calculate the revenure for a specific row in the data in a certain month
	public int calculateRevenuePerMonth(String inputDate, String[] dataLine) {
		return (int) (calculateRelativePartOfMonthForPayment(inputDate, dataLine)
				* Integer.parseInt(dataLine[Consts.MONTHLY_PRICE_INDEX]));
	}

	//calculate the relative part of the month for payment calculation
	private float calculateRelativePartOfMonthForPayment(String inputDate, String[] dataLine) {
		int numOfDaysForPayment = calculateNumOfPayingDays(inputDate, dataLine);
		String[] splittedInputDate = inputDate.split("-");
		float relativePart = (float) numOfDaysForPayment / YearMonth.of(Integer.parseInt(splittedInputDate[0]), Integer.parseInt(splittedInputDate[1])).lengthOfMonth();
		return relativePart;
	}

	//calculate for a row - how many days should be billed according to a specific input
	private int calculateNumOfPayingDays(String inputDate, String[] dataLine) {
		Date inputDateObject = DateUtil.createDateObject(inputDate);
		Date startDateObject = DateUtil.createDateObject(dataLine[Consts.START_DAY_INDEX]);
		int numOfDaysInInputMonth = DateUtil.numberOfDaysInMonth(DateUtil.getYear(inputDateObject),
				DateUtil.getMonth(inputDateObject));
		Date lastDayOfInputMonth = DateUtil.createDateObject(inputDate + "-" + numOfDaysInInputMonth);
		Date endDateObject = null;
		if (dataLine.length == 4)
			endDateObject = DateUtil.createDateObject(dataLine[Consts.END_DAY_INDEX]);
		if (dataLine.length == 3 || endDateObject == null || endDateObject.after(lastDayOfInputMonth))
			endDateObject = lastDayOfInputMonth;

		//The logic of paymant days calculation
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
