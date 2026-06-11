package Week10.Takehome.weather;

import Week10.Takehome.maps.TreeMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ignore this file. This file was created to test each of the methods in the treemap. Most of the code
 * was copied from the TreeMap.java file.
 *
 * @author Kevin Flores
 * @version 1.0
 */
public class TestTree {
    private static final int FIRST_YEAR = 1946;
    private static final int LAST_YEAR  = 2023;

    public static void main(String[] args){
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

        TreeMap<Integer, WeatherRecord> map = new TreeMap<>();
        map.addBalanced(keys, values);

        // Testing methods
        System.out.println(map.containsKey(1948));
        System.out.println(map.get(1950));
        WeatherRecord maxTempTest = map.get(2021);
        System.out.println(map.containsValue(maxTempTest));
    }

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
}
