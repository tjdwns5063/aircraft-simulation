package aircraft_simulation.simulator;

import java.io.*;
import java.util.List;
import java.util.stream.*;
import aircraft_simulation.tower.*;
import aircraft_simulation.flyable.*;

public class Simulator {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("too many args");
        }

        ScenarioParser scenarioParser = new ScenarioParser(args[0]);
        WeatherTower weatherTower = new WeatherTower();

        scenarioParser.parseFlyable().forEach(flyable -> { 
            flyable.registerTower(weatherTower);
            weatherTower.register(flyable); 
        });

        LongStream.range(0, scenarioParser.parseSimulateTime()).forEach( i -> weatherTower.changeWeather() );
    }
}