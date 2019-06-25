package weproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		try {
			main.runMainLogic();
		} catch (IOException e) {
			System.out.println("An error occurred");
		}
	}

	private void runMainLogic() throws IOException {
		System.out.println("Main class");
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\workspace\\we\\data.csv"));
		String header = csvReader.readLine();
		String row = csvReader.readLine();
		while (row != null && !row.isEmpty()) {
			String[] data = row.split(",");
			System.out.println(data.length);
			//logic should be here
			//call first algo and sum
			//call second algo and sum
			row = csvReader.readLine();
		}
		csvReader.close();
	}

}
