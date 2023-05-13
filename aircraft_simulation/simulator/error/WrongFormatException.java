package aircraft_simulation.simulator.error;

import java.lang.IllegalArgumentException;

public class WrongFormatException extends IllegalArgumentException {
    public WrongFormatException() {
        super("Wrong format. Please, check your scenario file.");
    }
}
