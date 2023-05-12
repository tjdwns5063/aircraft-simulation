package aircraft_simulation.flyable;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public String getFormattedName() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}