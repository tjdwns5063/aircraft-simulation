package aircraft_simulation.flyable;

import aircraft_simulation.simulator.WeatherProvider;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherProvider weatherProvider;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
        weatherProvider = WeatherProvider.create();
    }

    @Override
    public void updateConditions() {}

    @Override
    public String getFormattedName() { return ""; }
}