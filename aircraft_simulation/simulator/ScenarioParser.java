package aircraft_simulation.simulator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import aircraft_simulation.simulator.error.*;
import aircraft_simulation.flyable.Flyable;
import aircraft_simulation.flyable.AircraftFactory;
import aircraft_simulation.flyable.Coordinates;

public class ScenarioParser {
    String scenarioPath;
    AircraftFactory aircraftFactory = AircraftFactory.create();

    private Stream<String> createStream() throws IOException {
        return Files.lines(Paths.get(scenarioPath));
    }

    public ScenarioParser(String scenarioPath) {
        this.scenarioPath = scenarioPath;
    }

    public long parseSimulateTime() throws IOException {
        List<Long> list = createStream().limit(1).filter( str -> Validator.isInteger(str) ).map( str -> Long.parseLong(str)).collect(Collectors.toList());

        if (list.isEmpty()) throw new WrongFormatException();
        return list.get(0);
    }

    public List<Flyable> parseFlyable() throws IOException {
        if (!Validator.checkAircraftFormat(createStream().skip(1))) throw new WrongFormatException();

        return createStream().skip(1).map( str -> 
            str.split(" ")
        ).filter( strArr -> strArr.length == 5).map( strArr ->
            aircraftFactory.newAircraft(
                strArr[0], 
                strArr[1],
                aircraftFactory.newCoordinates(
                    Integer.parseInt(strArr[2]),
                    Integer.parseInt(strArr[3]), 
                    Integer.parseInt(strArr[4])
                )
            )
        ).collect(Collectors.toList());
    }
}