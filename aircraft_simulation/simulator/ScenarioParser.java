package aircraft_simulation.simulator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.IllegalArgumentException;
import aircraft_simulation.flyable.Flyable;
import aircraft_simulation.flyable.AircraftFactory;
import aircraft_simulation.flyable.Coordinates;

public class ScenarioParser {
    String scenarioPath;

    public ScenarioParser(String scenarioPath) throws IOException {
        this.scenarioPath = scenarioPath;
    }

    public long parseSimulateTime() throws IOException {
        Stream<String> stream = Files.lines(Paths.get(scenarioPath)).limit(1);
        List<Long> list = stream.map( str -> Long.parseLong(str)).collect(Collectors.toList());

        if (list.isEmpty()) throw new IllegalArgumentException("format is wrong");
        return list.get(0);
    }

    public List<Flyable> parseFlyable(AircraftFactory aircraftFactory) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(scenarioPath)).skip(1);

        return stream.map( str -> 
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