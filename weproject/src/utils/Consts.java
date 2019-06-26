package utils;

import java.util.Arrays;
import java.util.List;

public abstract class Consts {
	// indexes of columns in csv data file
	public static final int CAPACITY_INDEX = 0;
	public static final int MONTHLY_PRICE_INDEX = 1;
	public static final int START_DAY_INDEX = 2;
	public static final int END_DAY_INDEX = 3;

	// Input properties - user should only change this
	public static final List<String> INPUT_LIST = Arrays.asList("2013-01", "2013-06", "2014-03", "2014-09", "2015-07");
	public static final String INPUT_FILE_PATH = System.getProperty("user.dir") + "\\data.csv";

}
