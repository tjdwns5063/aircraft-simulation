package aircraft_simulation.simulator;

import java.io.*;
import java.util.List;
import java.util.stream.*;
import aircraft_simulation.tower.*;
import aircraft_simulation.flyable.*;
import aircraft_simulation.simulator.error.*;

public class Simulator {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("too many args");
        }

        try {
            simulate(args[0]);
        } catch (IOException err) {
            System.out.println("Cannot open file. Please, Check file name.");
        } catch (WrongFormatException err) {
            System.out.println(err.getMessage());
        }
    }

    private static void simulate(String path) throws IOException {
        ScenarioParser scenarioParser = new ScenarioParser(path);
        WeatherTower weatherTower = new WeatherTower();
        long simulateTime = scenarioParser.parseSimulateTime();

        scenarioParser.parseFlyable().forEach(flyable -> { 
            flyable.registerTower(weatherTower);
            weatherTower.register(flyable); 
        });

        LongStream.range(0, simulateTime).forEach( i -> weatherTower.changeWeather() );
    }
}