package taxi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Evegeny on 14/12/2016.
 */
@Data
@AllArgsConstructor
@Builder
public class Trip implements Serializable{
    private String id;
    private int km;
    private String city;

    public static Trip convertLineToTrip(String line) {
        String[] words = line.split(" ");
        return Trip.builder().id(words[0]).city(words[1]).km(Integer.parseInt(words[2])).build();
    }

    public boolean bostonFilter() {
        return city.equals("boston");
    }

    public static Trip summarizeTrips(Trip trip1, Trip trip2) {
        return new Trip("-", trip1.km + trip2.km, "-");
    }

}












