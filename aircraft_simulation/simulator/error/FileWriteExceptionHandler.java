package aircraft_simulation.simulator.error;

public class  FileWriteExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println(exception.getMessage());
    }
}