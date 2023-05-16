package aircraft_simulation.flyable;

import aircraft_simulation.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract String updateConditions();

    public abstract String getFormattedName();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }
}