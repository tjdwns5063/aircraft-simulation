package aircraft_simulation.flyable;

import aircraft_simulation.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public abstract String getFormattedName();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }
}