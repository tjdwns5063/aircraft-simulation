package aircraft_simulation.simulator;

import java.io.FileOutputStream;
import java.io.IOException;
import aircraft_simulation.simulator.error.FileWriteException;

public class FileWriter {
    private FileOutputStream outputStream;
    private static FileWriter INSTANCE = null;
    
    private class FileContract {
        private static final String FILE_NAME = "./simulation.txt";
    }

    private FileWriter() throws IOException {
        outputStream = new FileOutputStream(FileContract.FILE_NAME);
    }

    public static FileWriter from() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new FileWriter();
        }
        return INSTANCE;
    }

    public synchronized void writeToFile(String content) {
        try {
            outputStream.write(content.getBytes());
        } catch (IOException err) {
            throw new FileWriteException();
        }
    }
}