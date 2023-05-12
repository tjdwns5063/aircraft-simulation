package aircraft_simulation.tower;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import aircraft_simulation.flyable.Flyable;
import aircraft_simulation.flyable.Aircraft;
import aircraft_simulation.flyable.AircraftFactory;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private Queue<Flyable> unregisterQ = new LinkedList<>();

    protected void conditionChanged() {
        observers.stream().forEach( observer -> observer.updateConditions() );
        
        observers.removeAll(unregisterQ);
    }

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);

        System.out.println("Tower says: " + p_flyable.getFormattedName() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        unregisterQ.add(p_flyable);

        System.out.println("Tower says: " + p_flyable.getFormattedName() + " unregistered from weather tower.");
    }
}