package aircraft_simulation.simulator.error;

import java.lang.RuntimeException;

public class FileWriteException extends RuntimeException {
    public FileWriteException() {
        super("Occured file write error. Please, restart program.");
    }
}
