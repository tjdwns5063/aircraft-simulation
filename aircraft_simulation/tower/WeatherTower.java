package aircraft_simulation.tower;

import aircraft_simulation.simulator.WeatherProvider;
import aircraft_simulation.flyable.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.create().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }
}