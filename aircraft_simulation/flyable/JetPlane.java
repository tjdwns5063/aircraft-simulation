package aircraft_simulation.flyable;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (Weather.valueOf(weather)) {
            case RAIN: coordinates.addLatitude(5);
                System.out.println(getFormattedName() + ": It’s raining. Better watch out for lightings.");
                break ;
            case FOG: coordinates.addLatitude(1);
                System.out.println(getFormattedName() + ": OMG! Fog is making it really hard to see anything.");
                break ;
            case SUN: coordinates.addLatitude(10);
                coordinates.addHeight(2);
                System.out.println(getFormattedName() + ": It’s good weather to travel.");
                break ;
            case SNOW: coordinates.addHeight(-7);
                System.out.println(getFormattedName() + ": OMG! Winter is coming!");
                break ;
            default: throw new IllegalArgumentException("wrong weather");
        }

        if (coordinates.isLanded())
            weatherTower.unregister(this);
    }

    @Override
    public String getFormattedName() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}