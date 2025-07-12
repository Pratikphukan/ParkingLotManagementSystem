package com.pms.models.parkinglot;

import lombok.Getter;

@Getter
public enum ParkingSpotStatus {

    AVAILABLE("available"), UNAVAILABLE("unavailable"), OCCUPIED("occupied");

    private final String parkingSpotStatus;

    ParkingSpotStatus(String parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
