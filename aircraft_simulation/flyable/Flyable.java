package aircraft_simulation.flyable;

import aircraft_simulation.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void update();

    public void registerTower(WeatherTower p_tower) {
        p_tower.register(this);
    }
}