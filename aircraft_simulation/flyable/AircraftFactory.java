package aircraft_simulation.flyable;

import java.lang.IllegalArgumentException;
import java.lang.Enum;
import aircraft_simulation.flyable.Coordinates;

public class AircraftFactory {
    private static AircraftFactory INSTANCE = null;
    private long id = 0;

    private enum FlyableType {
        HELICOPTER("Helicopter"),
        JETPLANE("JetPlane"),
        BALOON("Baloon");

        private final String value;
        FlyableType(String value) { this.value = value; }
        public String getValue() { return value; }
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
        switch(FlyableType.valueOf(p_type)) {
            // case HELICOPTER: return new Helicopter(id, p_name, p_coordinates);
            // case JETPLANE: return new JetPlane(id, p_name, p_coordinates);
            // case BALOON: return new Baloon(id, p_name, p_coordinates);
            default: throw new IllegalArgumentException("wrong type");
        }
    }
}