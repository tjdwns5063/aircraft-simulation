package aircraft_simulation.flyable;

import java.io.IOException;
import java.lang.StringBuilder;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        StringBuilder message = new StringBuilder();

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addLatitude(5);
                message.append(getFormattedName() + ": It’s raining. Better watch out for lightings.\n");
                break ;
            case FOG: coordinates.addLatitude(1);
                message.append(getFormattedName() + ": OMG! Fog is making it really hard to see anything.\n");
                break ;
            case SUN: coordinates.addLatitude(10);
                coordinates.addHeight(2);
                message.append(getFormattedName() + ": It’s good weather to travel.\n");
                break ;
            case SNOW: coordinates.addHeight(-7);
                message.append(getFormattedName() + ": OMG! Winter is coming!\n");
                break ;
            default: throw new IllegalArgumentException("wrong weather");
        }

        if (coordinates.isLanded())
            message.append(weatherTower.unregister(this));
        
        return message.toString();
    }

    @Override
    public String getFormattedName() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}