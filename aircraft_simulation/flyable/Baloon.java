package aircraft_simulation.flyable;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public String getFormattedName() {
        return "Baloon#" + name + "(" + id + ")";
    }
}