package aircraft_simulation.flyable;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addHeight(-5);
                System.out.println(getFormattedName() + ": Damn you rain! You messed up my baloon.");
                break ;
            case FOG: coordinates.addHeight(-3);
                System.out.println(getFormattedName() + ": I can’t see my baloon.");
                break ;
            case SUN: coordinates.addLongitude(2);
                coordinates.addHeight(4);
                System.out.println(getFormattedName() + ": Let’s enjoy the good weather and take some pics.");
                break ;
            case SNOW: coordinates.addHeight(-15);
                System.out.println(getFormattedName() + ": It’s snowing. We’re gonna crash.");
                break ;
            default: throw new IllegalArgumentException("wrong weather");    
        }
    }

    @Override
    public String getFormattedName() {
        return "Baloon#" + name + "(" + id + ")";
    }
}