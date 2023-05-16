package aircraft_simulation.simulator.error;

import java.lang.RuntimeException;

public class ArgumentSizeException extends RuntimeException {
    public ArgumentSizeException() {
        super();
    }

    public ArgumentSizeException(String message) {
        super(message);
    }

    public ArgumentSizeException(Exception cause) {
        super(cause);
    }

    public ArgumentSizeException(String message, Exception cause) {
        super(message, cause);
    }
}