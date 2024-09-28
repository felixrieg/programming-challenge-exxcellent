package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.models.ModelException;
import de.exxcellent.challenge.models.WeatherModel;
import de.exxcellent.challenge.reader.CSVReader;

public class CSVReaderTest {

    class FaultyWeatherModel {
        private int day;
        private int mxT;
        private int mnT;
        private int faultyField;

        public FaultyWeatherModel() {
        }

        public int getDay() {
            return day;
        }

        public int getMxT() {
            return mxT;
        }

        public int getMnT() {
            return mnT;
        }

        public int getFaultyField() {
            return faultyField;
        }

    }

    @Test
    public void testReadWeatherData() {
        CSVReader<WeatherModel> reader = new CSVReader<>();
        try {
            List<WeatherModel> weatherData = reader.readFile("./src/test/resources/de/exxcellent/challenge/weather.csv",
                    WeatherModel.class);
            assertEquals(weatherData.get(0), new WeatherModel(1, 88, 59));
            assertEquals(weatherData.get(1), new WeatherModel(2, 79, 63));
            assertEquals(weatherData.get(29), new WeatherModel(30, 90, 45));
        } catch (Exception exception) {
            assert false;
        }
    }

    @Test
    public void testReadWeatherDataFaulty() {
        // this readFile should throw a ModelException
        CSVReader<FaultyWeatherModel> reader = new CSVReader<>();
        try {
            reader.readFile(
                    "./src/test/resources/de/exxcellent/challenge/weather.csv",
                    FaultyWeatherModel.class);

            assert false;
        } catch (ModelException exception) {
            assertEquals(exception.getMessage(), "Column faultyField not found in file");
        } catch (Exception exception) {
            assert false;
        }
    }

    @Test
    public void testFileDoesNotExist() {
        // this readFile should throw a ModelException
        CSVReader<WeatherModel> reader = new CSVReader<>();
        try {
            reader.readFile(
                    "any/path/to/nothingness.csv",
                    WeatherModel.class);

            assert false;
        } catch (FileNotFoundException exception) {
            assertEquals(exception.getMessage(), "any/path/to/nothingness.csv (No such file or directory)");
        } catch (Exception exception) {
            assert false;
        }
    }
}
