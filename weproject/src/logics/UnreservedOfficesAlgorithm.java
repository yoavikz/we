package logics;

public class UnreservedOfficesAlgorithm {
	public int calculateUnreservedOfficesCapacityPerMonth(String inputDate, String[] dataRow) {
		int numOfDaysForPayment = AlgorithmUtil.calculateNumOfPayingDays(inputDate, dataRow);
		if (numOfDaysForPayment >= 1)
			return 0;
		else
			return 1;
	}
}
