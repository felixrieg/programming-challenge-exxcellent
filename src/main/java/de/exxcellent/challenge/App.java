package de.exxcellent.challenge;

import java.io.File;
import java.util.Scanner;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * 
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String dayWithSmallestTempSpread = "Someday";
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …

        // Your preparation code …

        String weatherPath = "./src/main/resources/de/exxcellent/challenge/weather.csv";

        try (Scanner scanner = new Scanner(new File(weatherPath))) {
            String[] columns = scanner.nextLine().split(",");

            // check that the right columns are as expected
            assert columns[0].equals("Day");
            assert columns[1].equals("MxT");
            assert columns[2].equals("MnT");

            int dayIndex = -1;
            int minTempSpread = -1;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");

                int day = Integer.parseInt(line[0]);
                int maxTemp = Integer.parseInt(line[1]);
                int minTemp = Integer.parseInt(line[2]);
                int newSpread = maxTemp - minTemp;

                if (minTempSpread == -1 || newSpread < minTempSpread) {
                    minTempSpread = newSpread;
                    dayIndex = day;
                }
            }

            if (dayIndex != -1) {
                dayWithSmallestTempSpread = Integer.toString(dayIndex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
