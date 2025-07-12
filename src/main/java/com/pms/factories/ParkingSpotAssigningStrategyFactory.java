package com.pms.factories;

import com.pms.strategies.spotassignmentstrategy.NearestParkingSpotAssigningStrategy;
import com.pms.strategies.spotassignmentstrategy.ParkingSpotAssigningStrategy;
import com.pms.strategies.spotassignmentstrategy.PriorityParkingSpotAssigningStrategy;
import com.pms.strategies.spotassignmentstrategy.RandomParkingSpotAssigningStrategy;

public class ParkingSpotAssigningStrategyFactory {

    public static ParkingSpotAssigningStrategy getSpotAssignmentStrategy(String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "nearest":
                return new NearestParkingSpotAssigningStrategy();
            case "random":
                return new RandomParkingSpotAssigningStrategy();
            case "priority":
                return new PriorityParkingSpotAssigningStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }
    }
}
