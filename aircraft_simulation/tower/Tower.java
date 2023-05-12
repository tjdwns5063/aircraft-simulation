package aircraft_simulation.tower;

import java.util.List;
import aircraft_simulation.flyable.Flyable;

public class Tower {
    private List<Flyable> observers;

    protected void conditionChanged() {
        for (Flyable observer: observers) {
            observer.updateConditions();
        }
    }

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }
}