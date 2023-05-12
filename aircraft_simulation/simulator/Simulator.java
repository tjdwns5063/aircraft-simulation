package aircraft_simulation.simulator;

import java.io.*;
import aircraft_simulation.tower.*;
import aircraft_simulation.flyable.*;

public class Simulator {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("too many args");
        }

        Tower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.create();

        Flyable helicopter = aircraftFactory.newAircraft("Helicopter", "H1", aircraftFactory.newCoordinates(10, 10, 10));
        Flyable baloon = aircraftFactory.newAircraft("Baloon", "B1", aircraftFactory.newCoordinates(10, 10, 10));
        Flyable jetPlane = aircraftFactory.newAircraft("JetPlane", "J1", aircraftFactory.newCoordinates(10, 10, 10));
        Flyable baloon2 = aircraftFactory.newAircraft("Baloon", "B2", aircraftFactory.newCoordinates(10, 10, 10));

        weatherTower.register(helicopter);
        weatherTower.register(baloon);
        weatherTower.register(jetPlane);
        weatherTower.register(baloon2);
        weatherTower.unregister(baloon);
    }
}