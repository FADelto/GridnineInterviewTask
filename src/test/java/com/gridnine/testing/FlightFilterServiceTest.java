package com.gridnine.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterServiceTest {

    private static FlightFilterService flightFilterService;
    private static List<Flight> flights;

    @BeforeAll
    static void setUp() {
        flightFilterService = new FlightFilterService();
        flights = FlightBuilder.createFlights();
    }

    @Test
    void testFilterFlightsBeforeCurrentTime() {
        List<Flight> result = flightFilterService.filterFlightsBeforeCurrentTime(flights);
        assertEquals(5, result.size());
    }

    @Test
    void testFilterFlightsWithArrivalBeforeDeparture() {
        List<Flight> result = flightFilterService.filterFlightsWithArrivalBeforeDeparture(flights);
        assertEquals(5, result.size());
    }

    @Test
    void testFilterFlightsWithLongGroundTime() {
        List<Flight> result = flightFilterService.filterFlightsWithLongGroundTime(flights);
        assertEquals(4, result.size());
    }
}
