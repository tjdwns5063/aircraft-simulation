package aircraft_simulation.simulator.error;

import java.lang.Exception;

public interface ExceptionHandler {
    public abstract void handle(Exception exception);
}