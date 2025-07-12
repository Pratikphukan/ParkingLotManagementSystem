package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.vehicle.Vehicle;
import com.pms.models.vehicle.VehicleTypePrice;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
public class ParkingLot extends BaseModel {

    @Setter
    private String address;

    private List<ParkingFloor> parkingFloors;

    private List<Gate> gates;

    private Map<Vehicle, VehicleTypePrice> vehicleTypePriceMap; //parking lot specific data

    public ParkingLot(Long id, String address) {
        super(id);
        this.address = address;
    }
}
