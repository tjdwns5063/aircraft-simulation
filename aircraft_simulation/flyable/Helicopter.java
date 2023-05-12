package aircraft_simulation.flyable;

import java.lang.IllegalArgumentException;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addLongitude(5);
                System.out.println(getFormattedName() + ": This is wet.");
                break ;
            case FOG: coordinates.addLongitude(1);
                System.out.println(getFormattedName() + ": I can’t get my eyesight!");
                break ;
            case SUN: coordinates.addLongitude(10);
                coordinates.addHeight(2);
                System.out.println(getFormattedName() + ": This is hot.");
                break ;
            case SNOW: coordinates.addHeight(-12);
                System.out.println(getFormattedName() + ": My rotor is going to freeze!");
                break ;
            default: throw new IllegalArgumentException("wrong weather");
        }
    }

    @Override
    public String getFormattedName() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}