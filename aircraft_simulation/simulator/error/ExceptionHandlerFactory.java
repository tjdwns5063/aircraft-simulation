package aircraft_simulation.simulator.error;

public class ExceptionHandlerFactory {
    private ExceptionHandlerFactory() {}

    public static ExceptionHandler of(Exception exception) {
        System.out.println(exception.getClass().getSimpleName());
        String name = exception.getClass().getSimpleName();
        ExceptionHandler handler = new UnknownExceptionHandler();

        switch (name) {
            case "FileNotFoundException": handler = new FileNotFoundExceptionHandler();
                break;
            case "NoSuchFileException": handler = new FileNotFoundExceptionHandler();
                break;
            case "FileWriteException": handler = new FileWriteExceptionHandler();
                break;
            case "IOException": handler = new IOExceptionHandler();
                break;
            case "WrongFormatException": handler = new WrongFormatExceptionHandler();
                break;
            case "IllegalArgumentException": handler = new IllegalArgumentExceptionHandler();
                break;
            case "ArgumentSizeException": handler = new ArgumentSizeExceptionHandler();
        }
        return handler;
    }
}