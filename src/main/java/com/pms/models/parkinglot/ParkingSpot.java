package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.vehicle.VehicleType;
import lombok.Getter;

@Getter
public class ParkingSpot extends BaseModel {

    private Integer spotNumber;

    private VehicleType vehicleType;

    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot(Long id, VehicleType vehicleType) {
        super(id);
        this.vehicleType = vehicleType;
    }
}
