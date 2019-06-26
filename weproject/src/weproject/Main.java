package weproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import utils.Consts;
import utils.DateUtil;

public class Main {
	static Map<String, Integer> revenuesPerMonth = new HashMap<String, Integer>();
	static Map<String, Integer> unreservedCapacityPerMonth = new HashMap<String, Integer>();
	static RevenueCalculationAlgorithm revenueCalculationAlgorithm = new RevenueCalculationAlgorithm();
	static UnreservedOfficesAlgorithm unreservedOfficesAlgorithm = new UnreservedOfficesAlgorithm();

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		initializeMap(revenuesPerMonth);
		initializeMap(unreservedCapacityPerMonth);
		main.runMainLogic();
		printOutput();
	}

	private void runMainLogic() throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\workspace\\we\\data2.csv"));
		String header = csvReader.readLine();
		String row = csvReader.readLine();
		while (row != null && !row.isEmpty()) {
			String[] data = row.replaceAll(" ", "").split(",");
			for (String inputDate : Consts.INPUT_LIST) {
				revenuesPerMonth.put(inputDate, revenuesPerMonth.get(inputDate)
						+ revenueCalculationAlgorithm.calculateRevenuePerMonth(inputDate, data));
				unreservedCapacityPerMonth.put(inputDate, unreservedCapacityPerMonth.get(inputDate)
						+ unreservedOfficesAlgorithm.calculateUnreservedOfficesCapacityPerMonth(inputDate, data));
			}
			row = csvReader.readLine();
		}
		csvReader.close();
	}

	private static void initializeMap(Map<String, Integer> map) {
		for (String inputMonth : Consts.INPUT_LIST) {
			map.put(inputMonth, 0);
		}
	}

	private static void printOutput() {
		// TODO: Fix this ugly duplicate code, send the map and the required text to
		// print as method args
		System.out.println("=====Revenues summary=====\n");
		for (String month : revenuesPerMonth.keySet()) {
			System.out.println("The revenue for month " + month + " is " + revenuesPerMonth.get(month) + "$");
		}

		System.out.println("\n=====Unreserved capacity summary=====\n");
		for (String month : unreservedCapacityPerMonth.keySet()) {
			System.out.println(
					"The unreserved capacity for month " + month + " is " + unreservedCapacityPerMonth.get(month));
		}

	}

}
