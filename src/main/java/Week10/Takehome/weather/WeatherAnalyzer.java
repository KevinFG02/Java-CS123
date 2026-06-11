package Week10.Takehome.weather;

import Week10.Takehome.maps.TreeMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Analyzing the weather in Seattle while answering 5 questions.
 *
 * @author Kevin Flores
 * @version 1.0
 *
 * Reads annual Seattle weather data into a TreeMap and answers
 * five analysis questions about the dataset.
 *
 * The loadData() method and main() boilerplate are provided for you.
 * Your job is to implement the five analysis methods at the bottom of this file.
 *
 * You may only interact with the TreeMap using these four methods:
 *   add(), get(), containsKey(), containsValue()
 */
public class WeatherAnalyzer {

    private static final int FIRST_YEAR = 1946;
    private static final int LAST_YEAR  = 2023;

    // -----------------------------------------------------------------------
    // Provided — do not modify
    // -----------------------------------------------------------------------

    public static void main(String[] args) {
        // Load the raw data into parallel arrays
        Integer[] years = new Integer[LAST_YEAR - FIRST_YEAR + 1];
        WeatherRecord[] records = new WeatherRecord[years.length];
        int count = loadData("src/main/java/Week10/Takehome/seattle-weather.csv", years, records); // Edited the file path

        if (count == 0) {
            System.out.println("No data loaded. Check that seattle_weather.csv is present.");
            return;
        }

        // Trim arrays to actual loaded size
        Integer[] keys = new Integer[count];
        WeatherRecord[] values = new WeatherRecord[count];
        for (int i = 0; i < count; i++) {
            keys[i]   = years[i];
            values[i] = records[i];
        }

        // Build a balanced tree — never call add() in a loop with sorted data!
        TreeMap<Integer, WeatherRecord> map = new TreeMap<>();
        map.addBalanced(keys, values);

        System.out.println("Seattle Weather Analysis — Sea-Tac Airport (1946–2023)");
        System.out.println("--------------------------------------------------------");
        System.out.println();

        question1(map);
        question2(map);
        question3(map);
        question4(map);
        question5(map);
    }

    /**
     * Reads the CSV file into parallel arrays of years and WeatherRecords.
     * Lines beginning with '#' are treated as comments and skipped.
     *
     * @param filename path to the CSV file
     * @param years    output array to fill with year keys
     * @param records  output array to fill with WeatherRecord values
     * @return the number of rows successfully loaded
     */
    private static int loadData(String filename, Integer[] years, WeatherRecord[] records) {
        int count = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(",");
                if (parts.length < 6) continue;

                years[count] = Integer.parseInt(parts[0].trim());
                records[count] = new WeatherRecord(
                        Double.parseDouble(parts[1].trim()),
                        Double.parseDouble(parts[2].trim()),
                        Integer.parseInt(parts[3].trim()),
                        Integer.parseInt(parts[4].trim()),
                        Integer.parseInt(parts[5].trim())
                );
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: could not find '" + filename + "'");
        }
        return count;
    }

    // -----------------------------------------------------------------------
    // Your implementation goes here
    // -----------------------------------------------------------------------

    /**
     * Q1: What was the average temperature in Seattle during the 1980s (1980–1989)?
     *
     * Hint: loop over the years in that range, use get() to retrieve each record,
     * accumulate the avgTempF values, then divide by the count.
     */
    private static void question1(TreeMap<Integer, WeatherRecord> map) {
        System.out.println("Q1: Average temperature during the 1980s (1980–1989)");
        // TODO: implement

        double averageTemp = 0;

        // Loops over the range of 1980-1989 to get the annual average temperature.
        for(int i = 0; i < 10; i++){
            WeatherRecord getAverageTemp = map.get(1980 + i);
            averageTemp = getAverageTemp.getAvgTempF() + averageTemp;
        }

        double result = averageTemp / 10;
        System.out.println("Average Temperature from 1980-1989 is " + result);
        System.out.println();
    }

    /**
     * Q2: How many years between 1990 and 2010 had more than 160 days of rain?
     * Print each qualifying year and its rain day count.
     *
     * Hint: loop over the range, use containsKey() to check if the year exists,
     * then get() to retrieve the record and check getDaysWithRain().
     */
    private static void question2(TreeMap<Integer, WeatherRecord> map) {
        System.out.println("Q2: Years with more than 160 rain days (1990–2010)");
        // TODO: implement
        int counter = 0;

        // Loops over the range of 1990-2010 to get the annual rain day count.
        for(int i = 0; i < 21; i++){
            WeatherRecord getRainDay = map.get(1990 + i);
            int compareDays = getRainDay.getDaysWithRain();

            // Evaluates if the rain day count surpasses 160 days.
            if(compareDays > 160){
                System.out.println("Year: " + (1990 + i) + ", Days of rain: " + getRainDay.getDaysWithRain());
                counter++;
            }
        }
        System.out.println(counter + " is the amount of years that have more 160 days of rain from 1990 to 2010.");
        System.out.println();
    }

    /**
     * Q3: What was the hottest single day ever recorded in the dataset? Which year?
     *
     * Hint: loop over all years in the dataset, track the highest maxTempF you find
     * and which year it came from.
     */
    private static void question3(TreeMap<Integer, WeatherRecord> map) {
        System.out.println("Q3: Hottest single day on record");
        // TODO: implement
        int recordTemp = 0;
        int saveYear = 0;

        // Loops over the entire dataset to find the hottest temperature recorded.
        for(int i = 0; i < map.size() - 1; i++){
            WeatherRecord getHighTemp = map.get(1946 + i);
            int compareTempDay = getHighTemp.getMaxTempF();

            /*Updates the recordTime variable if the current object has a higher temperature than
              the previous record. It also saves the current year if the previous condition is met.*/
            if(compareTempDay > recordTemp){
                recordTemp = compareTempDay;
                saveYear = 1946 + i;
            }
        }

        System.out.println("Highest Temperature ever recorded: " + recordTemp + ", Year: " + saveYear);
        System.out.println();
    }

    /**
     * Q4: Were there any years in the 1950s or 1960s where the max temp never reached 90F?
     * Print each qualifying year and its max temp.
     *
     * Hint: loop over 1950–1969 and check getMaxTempF() on each record.
     */
    private static void question4(TreeMap<Integer, WeatherRecord> map) {
        System.out.println("Q4: Years in the 1950s–1960s where max temp never reached 90°F");
        // TODO: implement
        int counter = 0;

        // Loops from 1950 to 1969 to evaluate the maximum temperature.
        for(int i = 0; i < 20; i++){
            WeatherRecord getHighTemp = map.get(1950 + i);
            int compareTempDay = getHighTemp.getMaxTempF();

            // Decides if the maximum temperature surpasses 90F and adds to a counter.
            if(compareTempDay < 90){
                counter++;
                System.out.println("Year: " + (1950 + i) + ", Temperature:" + compareTempDay);
            }
        }

        System.out.println(counter + " years had never reached 90F from 1950-1969.");
        System.out.println();
    }

    /**
     * Q5: Print total precipitation for each decade from the 1950s through the 2010s.
     *
     * Hint: use a loop within a loop — outer loop over decade start years
     * (1950, 1960, 1970...), inner loop over each year in that decade.
     * Accumulate getPrecipIn() for each decade and print the total.
     */
    private static void question5(TreeMap<Integer, WeatherRecord> map) {
        System.out.println("Q5: Total precipitation by decade");
        // TODO: implement
        int decadeCounter = 1940;
        int getYear;
        int intLimit;

        // Loops through each decade and updates the decade counter.
        for(int i = 0; i < 9; i++){
            double totalPrecip = 0;

            /* Changes the inner loop's stopping point and WeatherRecord object depending on the
               decade counter */
            if(decadeCounter < 1950){
                intLimit = 4;
                getYear = 1946;
            } else if (decadeCounter > 2010) {
                intLimit = 4;
                getYear = 2020;
            } else {
                intLimit = 10;
                getYear = decadeCounter;
            }

            /* An inner loop that accumulates the precipitation total for each year
            and adds it to a variable that represents the decade.*/
            for(int j = 0; j < intLimit; j++){
                WeatherRecord getPrecip = map.get(getYear + j);
                double annualPrecip = getPrecip.getPrecipIn();

                totalPrecip = annualPrecip + totalPrecip;
            }

            System.out.println(decadeCounter + "s: " + totalPrecip);
            decadeCounter = decadeCounter + 10;
        }

        System.out.println();
    }
}