package aircraft_simulation.simulator.error;

public class IOExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println("Fail reading file. Please, restart Program.");
    }
}