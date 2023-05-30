package aircraft_simulation.flyable;

import java.lang.IllegalArgumentException;
import java.lang.Enum;
import java.util.Queue;
import java.util.LinkedList;
import aircraft_simulation.flyable.Coordinates;

public class AircraftFactory {
    private static AircraftFactory INSTANCE = null;
    private static long id = 0;

    private enum FlyableType {
        Helicopter,
        JetPlane,
        Baloon;
    }

    public static AircraftFactory create() {
        if (INSTANCE == null) {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }
    
    public Coordinates newCoordinates(int p_longitude, int p_latitude, int p_height) {
        return new Coordinates(p_longitude, p_latitude, p_height);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Flyable aircraft = null;

        switch(FlyableType.valueOf(p_type)) {
            case Helicopter: aircraft = new Helicopter(++id, p_name, p_coordinates);
            case JetPlane: aircraft = new JetPlane(++id, p_name, p_coordinates);
            case Baloon: aircraft = new Baloon(++id, p_name, p_coordinates);
        }

        return aircraft;
    }
}