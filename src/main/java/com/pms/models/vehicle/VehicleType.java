package com.pms.models.vehicle;

import lombok.Getter;

@Getter
public enum VehicleType {

    SMALL("small"), MEDIUM("medium"), LARGE("large"), ELECTRIC("electric");

    private final String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
