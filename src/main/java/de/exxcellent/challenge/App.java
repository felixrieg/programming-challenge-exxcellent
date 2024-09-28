package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

import de.exxcellent.challenge.models.FootballModel;
import de.exxcellent.challenge.models.ModelException;
import de.exxcellent.challenge.models.WeatherModel;
import de.exxcellent.challenge.reader.CSVReader;

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
        String teamWithSmallestGoalSpread = "A good team";

        // Set File locations
        final String WEATHER_PATH = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        final String FOOTBALL_PATH = "./src/main/resources/de/exxcellent/challenge/football.csv";

        // Read weather data and find day with smallest temperature spread
        try {
            CSVReader<WeatherModel> weatherReader = new CSVReader<>();
            List<WeatherModel> weatherModels = weatherReader.readFile(WEATHER_PATH, WeatherModel.class);
            var minSpread = weatherModels.stream().min(Comparator.comparing(wm -> wm.getMxT() - wm.getMnT()));
            if (minSpread.isPresent()) {
                dayWithSmallestTempSpread = Integer.toString(minSpread.get().getDay());
            }

        } catch (ModelException | FileNotFoundException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        // Read football data and find team with smallest goal spread
        try {
            CSVReader<FootballModel> footballReader = new CSVReader<FootballModel>();
            List<FootballModel> footballModels = footballReader.readFile(FOOTBALL_PATH, FootballModel.class);
            var minDifference = footballModels.stream()
                    .min(Comparator
                            .comparing(
                                    fb -> fb.getGoals()
                                            - fb.getGoalsAllowed()));
            if (minDifference.isPresent()) {
                teamWithSmallestGoalSpread = minDifference.get().getTeam();
            }

        } catch (ModelException | FileNotFoundException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
