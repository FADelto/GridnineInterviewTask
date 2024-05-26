package com.gridnine.testing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightsList = FlightBuilder.createFlights();
        FlightFilterService flightFilterService = new FlightFilterService();
        System.out.println("Первое правило (Вылет после текущего момента времени):");
        System.out.println("Список перелётов до фильтра: ");
        System.out.println(flightsList);
        System.out.println("Список перелётов после фильтра: ");
        System.out.println(flightFilterService.filterFlightsBeforeCurrentTime(flightsList));
        System.out.println("\nВторое правило (Отсутствуют сегменты с датой прилёта раньше даты вылета):");
        System.out.println("Список перелётов до фильтра: ");
        System.out.println(flightsList);
        System.out.println("Список перелётов после фильтра: ");
        System.out.println(flightFilterService.filterFlightsWithArrivalBeforeDeparture(flightsList));
        System.out.println("\nТретье правило (Общее время, проведённое на земле не превышает два часа):");
        System.out.println("Список перелётов до фильтра: ");
        System.out.println(flightsList);
        System.out.println("Список перелётов после фильтра: ");
        System.out.println(flightFilterService.filterFlightsWithLongGroundTime(flightsList));
    }
}