package aircraft_simulation.flyable;

import java.lang.StringBuilder;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        StringBuilder message = new StringBuilder();

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addHeight(-5);
                message.append(getFormattedName() + ": Damn you rain! You messed up my baloon.\n");
                break ;
            case FOG: coordinates.addHeight(-3);
                message.append(getFormattedName() + ": I can’t see my baloon.\n");
                break ;
            case SUN: coordinates.addLongitude(2);
                coordinates.addHeight(4);
                message.append(getFormattedName() + ": Let’s enjoy the good weather and take some pics.\n");
                break ;
            case SNOW: coordinates.addHeight(-15);
                message.append(getFormattedName() + ": It’s snowing. We’re gonna crash.\n");
                break ;
        }

        if (coordinates.isLanded())
            message.append(weatherTower.unregister(this));

        return message.toString();
    }

    @Override
    public String getFormattedName() {
        return "Baloon#" + name + "(" + id + ")";
    }
}