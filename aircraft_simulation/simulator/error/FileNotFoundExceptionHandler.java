package aircraft_simulation.simulator.error;

public class FileNotFoundExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception exception) {
        System.out.println("Cannot find file. Please, Check file name.");
    }
}