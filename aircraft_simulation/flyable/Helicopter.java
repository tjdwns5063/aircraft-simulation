package aircraft_simulation.flyable;

import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;
import java.io.IOException;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        StringBuilder message = new StringBuilder();

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addLongitude(5);
                message.append(getFormattedName() + ": This is wet.\n");
                break ;
            case FOG: coordinates.addLongitude(1);
                message.append(getFormattedName() + ": I can’t get my eyesight!\n");
                break ;
            case SUN: coordinates.addLongitude(10);
                coordinates.addHeight(2);
                message.append(getFormattedName() + ": This is hot.\n");
                break ;
            case SNOW: coordinates.addHeight(-12);
                message.append(getFormattedName() + ": My rotor is going to freeze!\n");
                break ;
            default: throw new IllegalArgumentException("wrong weather");
        }

        if (coordinates.isLanded())
            message.append(weatherTower.unregister(this));
        
        return message.toString();
    }

    @Override
    public String getFormattedName() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}