package com.pms.models.parkinglot;

import com.pms.models.ElectricCharger;
import com.pms.models.vehicle.VehicleType;
import lombok.Getter;

@Getter
public class ElectricParkingSpot extends ParkingSpot {

    private ElectricCharger electricCharger;

    public ElectricParkingSpot(Long id) {
        super(id, VehicleType.ELECTRIC);
    }
}
