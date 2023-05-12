package aircraft_simulation.simulator;

import java.io.*;
import java.util.List;
import aircraft_simulation.tower.*;
import aircraft_simulation.flyable.*;

public class Simulator {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("too many args");
        }

        ScenarioParser scenarioParser = new ScenarioParser(args[0]);

        long simulateTimes = scenarioParser.parseSimulateTime();
        List<Flyable> flyables = scenarioParser.parseFlyable();
        WeatherTower weatherTower = new WeatherTower();

        flyables.stream().forEach( flyable -> weatherTower.register(flyable));
        while (--simulateTimes > 0) {
            weatherTower.changeWeather();
        }
    }
}