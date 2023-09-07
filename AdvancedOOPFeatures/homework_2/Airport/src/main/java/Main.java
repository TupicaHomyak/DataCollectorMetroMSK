import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//TODO В Main реализуйте метод findPlanesLeavingInTheNextTwoHours(),
// который должен вернуть список рейсов, вылетающих в ближайшие два часа,
// используя Stream API и lambda-выражения.

public class Main {
    public static void main(String[] args) {
        Airport airport1 = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport1);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        Date nowDate = Date.from(Instant.now());
        Date andTwoH = Date.from(Instant.now().plusSeconds(7200));

        return airport.getTerminals().stream()
                        .flatMap(terminal -> terminal.getFlights().stream())
                                .filter(flight -> flight.getDate().after(nowDate)
                                && flight.getDate().before((andTwoH))
                                && flight.getType() == Flight.Type.DEPARTURE)
                                .collect(Collectors.toList());
    }
}