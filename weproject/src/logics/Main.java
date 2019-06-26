package logics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import utils.Consts;

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
		BufferedReader csvReader = new BufferedReader(new FileReader(Consts.INPUT_FILE_PATH));
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
		for (String month : Consts.INPUT_LIST) {
			System.out.println(month + ": Expected revenue: $ " + revenuesPerMonth.get(month)
					+ ", expected total capacity of the unreserved offices: " + unreservedCapacityPerMonth.get(month));
		}
	}

}
