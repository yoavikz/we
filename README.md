
The assumptions I made while solving this task:
Each row in the csv file contains 3 or 4 parameters. If a certain row contains only 3 parameters the code will handle it as includes the fields: capacity, price and start date.
The data is valid and not corrupted in any way, and the first row is a header.

Project structure:
The project developed in Java contains 2 packages - 
“logics” - which contains the algorithms and the main method for the program.
Main class - Initializes two hashmaps for algorithms results, iterates the data and calls the algorithms for each row. Summing the results into the maps.
RevenueCalculationAlgorithm - This class has the logics which receive a row from the file with an input month, and return the amount of revenue.
UnreservedOfficesAlgorithm - This class has the logics which receive a row from the file with an input month, and return whether or not the office was reserved that month.
AlgorithmUtil - This is a util for both algorithms class, it has the logics of calculating how many days was the office reserved, in a specific month.
“utils” - contains util classes including “Consts” class which contains constant variables for the program.
Consts - An abstract class which holds the constans and input parameters for the program.
DateUtil - A util for date and time calculations.

How ro run the code:
Clone the code to your computer, and hit “run” :)

You can change the input list in Consts class by editing the variable “INPUT_LIST”. By default the program runs with this list of months as input : “2013-01", "2013-06", "2014-03", "2014-09", "2015-07".
The program will read the file “data.csv” from within the workspace, in the path “weproject/data.csv”. If you wish to change it you can do it by editing the parameter “INPUT_FILE_PATH” in the Consts class.



1. How much time did you spend?
Around 5 hours.
 
2. What was the most difficult thing for you?
I chose to develop with Java as I wanted to build a nice OOP design.  I am usually using Python for data analysis and working with files (you can see in my GitHub repositories), so I thought it would be nice to try doing it with Java for a change.
The main challenge was working dates and comparing times in Java. Some of the ‘Date’ class methods in java are deprecated, including the constructors, getters and setters. I was quite surprised to see how Java couldn’t yet supply another easy and readable date object to work with. I invested some time writing my own code for date objects creation and manipulation, using other objects like ‘Calendar’ ,’LocalDate’ and ‘YearMonth’.
 
3. What technical debt would you pay if you had one more iteration?

In this task focused mainly on submitting a basic flow with accurate algorithms to analyse the data.

In order to go forward with this task, I would:
Add a lot of automation. I am sure that many possible null pointers and other bugs and possible exceptions are hidden in the code, due to the assumption that I made.
Use polymorphism to allow adding more algorithms in the future and run in parallel. I would probably create an abstract base class or an interface called “Algorithm” and have all algorithm inherit/implement it.
Add output handler - ongoing writing output to a file so that the data is not lost if the program crashes. (When talking about working with larger data sets, of course).
Make the algorithms run on different threads in parallel. At the moment, the runtime of the program is limited to the slowest algorithm because they run one after the other.
Add log file with informative messages in different log level.
Export some code related to date manipulations from AlgorithmsUtil to DateUtil.
Export the program input variables (month input and csv path) to a properties file or program arguments.
