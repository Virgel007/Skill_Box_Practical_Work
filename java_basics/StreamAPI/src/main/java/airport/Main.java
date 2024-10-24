package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts().stream()
                .filter(a -> a.getModel().startsWith(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals().stream()
                .collect(Collectors.toMap(Terminal::getName, t -> t.getParkedAircrafts().size()));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        Instant departureTimeHour = Instant.now().plusSeconds(hours * 3600L);
        List<Flight> flightListDeparture = new ArrayList<>();
        airport.getTerminals()
                .forEach(t -> flightListDeparture.addAll(t.getFlights()));
        return flightListDeparture.stream()
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().isBefore(departureTimeHour))
                .filter(f -> f.getDate().isAfter(Instant.now()))
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        return airport.getTerminals().stream()
                .filter(t -> t.getName().contains(terminalName))
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.ARRIVAL))
                .filter(f -> f.getDate().isAfter(Instant.now()))
                .findAny();
    }
}