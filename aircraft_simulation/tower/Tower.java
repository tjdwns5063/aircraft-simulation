package aircraft_simulation.tower;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.StringBuilder;
import aircraft_simulation.flyable.Flyable;
import aircraft_simulation.flyable.Aircraft;
import aircraft_simulation.flyable.AircraftFactory;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private Queue<Flyable> unregisterQ = new LinkedList<>();

    protected String conditionChanged() {
        StringBuilder messages = new StringBuilder();

        observers.stream().forEach( observer -> 
            messages.append(observer.updateConditions()) 
        );
        
        observers.removeAll(unregisterQ);
        return messages.toString();
    }

    public String register(Flyable p_flyable) {
        observers.add(p_flyable);

        return "Tower says: " + p_flyable.getFormattedName() + " registered to weather tower.\n";
    }

    public String unregister(Flyable p_flyable) {
        unregisterQ.add(p_flyable);

        return "Tower says: " + p_flyable.getFormattedName() + " unregistered from weather tower.\n";
    }
}