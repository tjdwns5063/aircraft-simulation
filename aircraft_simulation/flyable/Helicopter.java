package aircraft_simulation.flyable;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public String getFormattedName() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}