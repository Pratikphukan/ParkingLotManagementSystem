package com.pms.services.factory;

import com.pms.services.strategies.spotassignmentstrategy.NearestParkingSpotAssigningStrategy;
import com.pms.services.strategies.spotassignmentstrategy.ParkingSpotAssigningStrategy;
import com.pms.services.strategies.spotassignmentstrategy.PriorityParkingSpotAssigningStrategy;
import com.pms.services.strategies.spotassignmentstrategy.RandomParkingSpotAssigningStrategy;

public class ParkingSpotAssigningStrategyFactory {

    public static ParkingSpotAssigningStrategy getSpotAssignmentStrategy(String strategyType) {
        return switch (strategyType.toLowerCase()) {
            case "nearest" -> new NearestParkingSpotAssigningStrategy();
            case "random" -> new RandomParkingSpotAssigningStrategy();
            case "priority" -> new PriorityParkingSpotAssigningStrategy();
            default -> throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        };
    }
}
