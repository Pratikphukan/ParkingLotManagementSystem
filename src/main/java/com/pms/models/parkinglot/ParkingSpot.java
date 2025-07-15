package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot extends BaseModel {

    private Integer spotNumber;

    private VehicleType vehicleType;

    private ParkingSpotStatus parkingSpotStatus;
}
