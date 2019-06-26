package weproject;

import java.time.YearMonth;
import utils.Consts;

public class RevenueCalculationAlgorithm {
	// calculate the revenue for a specific row in the data in a certain month
	public int calculateRevenuePerMonth(String inputDate, String[] dataRow) {
		return (int) (calculateRelativePartOfMonthForPayment(inputDate, dataRow)
				* Integer.parseInt(dataRow[Consts.MONTHLY_PRICE_INDEX]));
	}

	// calculate the relative part of the month for payment calculation
	private float calculateRelativePartOfMonthForPayment(String inputDate, String[] dataRow) {
		int numOfDaysForPayment = AlgorithmUtil.calculateNumOfPayingDays(inputDate, dataRow);
		String[] splittedInputDate = inputDate.split("-");
		float relativePart = (float) numOfDaysForPayment / YearMonth
				.of(Integer.parseInt(splittedInputDate[0]), Integer.parseInt(splittedInputDate[1])).lengthOfMonth();
		return relativePart;
	}
}
