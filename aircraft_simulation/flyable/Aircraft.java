package aircraft_simulation.flyable;

import java.io.IOException;
import aircraft_simulation.simulator.WeatherProvider;
import aircraft_simulation.simulator.FileWriter;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected enum Weather {
        RAIN,
        FOG,
        SUN,
        SNOW;
    }

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }

    @Override
    public String updateConditions() { return ""; }

    @Override
    public String getFormattedName() { return ""; }
}