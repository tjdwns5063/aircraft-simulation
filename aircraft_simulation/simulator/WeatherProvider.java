package aircraft_simulation.simulator;

import aircraft_simulation.flyable.Coordinates;

public class WeatherProvider {
    private String[] weather;
    private static WeatherProvider INSTANCE = null;

    private WeatherProvider() {
        weather = new String[4];

        weather[0] = "RAIN";
        weather[1] = "FOG";
        weather[2] = "SUN";
        weather[3] = "SNOW";
    }

    public static WeatherProvider create() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return "SNOW";
    }
}