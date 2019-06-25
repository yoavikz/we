package weproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import utils.Consts;
import utils.DateUtil;

public class Main {
	static Map<String, Integer> revenuesPerMonth = new HashMap<String, Integer>();
	static Map<String, Integer> unreservedCapacityPerMonth = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		Main main = new Main();
			initialize(revenuesPerMonth);
			initialize(unreservedCapacityPerMonth);
			main.runMainLogic();
			printOutput();
	}



	private void runMainLogic() throws IOException {
		RevenueCalculationAlgorithm revenueCalculationAlgorithm = new RevenueCalculationAlgorithm();
		UnreservedOfficesAlgorithm unreservedOfficesAlgorithm = new UnreservedOfficesAlgorithm();
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\workspace\\we\\data.csv"));
		String header = csvReader.readLine();
		String row = csvReader.readLine();
		while (row != null && !row.isEmpty()) {
			String[] data = row.split(",");
			for (String inputMonth : Consts.INPUT_LIST) {
				// call first algo and sum
				revenuesPerMonth.put(inputMonth, revenuesPerMonth.get(inputMonth)
						+ revenueCalculationAlgorithm.calculateRevenuePerMonth(inputMonth, data));
				// call second algo and sum
				unreservedCapacityPerMonth.put(inputMonth, unreservedCapacityPerMonth.get(inputMonth)
						+ unreservedOfficesAlgorithm.calculateUnreservedOfficesCapacityPerMonth(inputMonth, data));
			}
			row = csvReader.readLine();
		}
		csvReader.close();
	}

	private static void initialize(Map<String, Integer> map) {
		for (String inputMonth : Consts.INPUT_LIST) {
			map.put(inputMonth, 0);
		}
	}
	
	private static void printOutput() {
		//TODO: Fix this ugly duplicate code, send the map and the required text to print as method args
		System.out.println("Revenues summary");
		for (String month : revenuesPerMonth.keySet())
		{
			System.out.println("The revenue for month " + month + " is " + revenuesPerMonth.get(month));
		}
		
		System.out.println("Unreserved capacity summary");
		for (String month : unreservedCapacityPerMonth.keySet())
		{
			System.out.println("The unreserved capacity for month " + month + " is " + unreservedCapacityPerMonth.get(month));
		}

		
	}

}
