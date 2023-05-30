package aircraft_simulation.simulator;

import java.io.IOException;
import java.util.stream.Stream;

public class Validator {
    private Validator() {}

    public static boolean isInteger(String s) {
        return s.chars().allMatch( c -> Character.isDigit(c) );
    }

    public static boolean checkAircraftFormat(Stream<String> stream) {
        return stream.map( str -> str.split(" ") )
            .allMatch( strArr -> strArr.length == 5 && isInteger(strArr[2]) && isInteger(strArr[3]) && isInteger(strArr[4]));
    }
}