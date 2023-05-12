package aircraft_simulation.flyable;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    protected Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void addLongitude(int point) {
        longitude += point;
    }

    public void addLatitude(int point) {
        latitude += point;
    }

    public void addHeight(int point) {
        height += point;
    }
}