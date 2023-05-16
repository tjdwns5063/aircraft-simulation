package aircraft_simulation.simulator;

import java.io.*;
import java.util.List;
import java.util.stream.*;
import aircraft_simulation.tower.*;
import aircraft_simulation.flyable.*;
import aircraft_simulation.simulator.error.*;

public class Simulator {
    public static void main(String[] args) throws IOException {
        try {
            if (args.length != 1) throw new ArgumentSizeException("Wrong argument count. Please, Input single argument.");
            simulate(args[0]);
        } catch (Exception exception) {
            ExceptionHandler handler = ExceptionHandlerFactory.of(exception);

            handler.handle(exception);
        }
    }

    private static void simulate(String path) throws IOException, FileNotFoundException {
        ScenarioParser scenarioParser = new ScenarioParser(path);
        WeatherTower weatherTower = new WeatherTower();
        FileWriter fileWriter = FileWriter.from();
        long simulateTime = scenarioParser.parseSimulateTime();

        scenarioParser.parseFlyable().forEach(flyable -> { 
            flyable.registerTower(weatherTower);
            fileWriter.writeToFile(weatherTower.register(flyable)); 
        });

        LongStream.range(0, simulateTime).forEach( i -> 
            fileWriter.writeToFile(weatherTower.changeWeather()) 
        );
    }
}