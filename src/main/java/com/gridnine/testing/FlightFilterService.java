package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterService {
    List<Flight> filterFlightsBeforeCurrentTime(List<Flight> flightsList){
        return flightsList.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
    List<Flight> filterFlightsWithArrivalBeforeDeparture(List<Flight> flightsList){
        return flightsList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    List<Flight> filterFlightsWithLongGroundTime(List<Flight> flightsList) {
        List<Flight> thirdFilter = new ArrayList<>();
        for (Flight flight : flightsList) {
            long groundTime = 0;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                groundTime += flight.getSegments().get(i + 1).getDepartureDate().toEpochSecond(ZoneOffset.UTC) -
                        flight.getSegments().get(i).getArrivalDate().toEpochSecond(ZoneOffset.UTC);
            }
            if (groundTime <= 7200) {
                thirdFilter.add(flight);
            }
        }
        return thirdFilter;
    }
}
