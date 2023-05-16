package aircraft_simulation.simulator.error;

public class UnknownExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println("Occured Unknown error. Please, report an developer to this error.");
    }
}