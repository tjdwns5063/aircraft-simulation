package aircraft_simulation.simulator.error;

public class ArgumentSizeExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println(exception.getMessage());
    }
}