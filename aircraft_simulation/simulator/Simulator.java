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
        } catch (FileNotFoundException err) {
            System.out.println("Cannot find file. Please, Check file name.");
        } catch (FileWriteException err) {
            System.out.println(err.getMessage());
        } catch (IOException err) {
            System.out.println("Fail reading file. Please, restart Program.");
        } catch (WrongFormatException err) {
            System.out.println(err.getMessage());
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
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