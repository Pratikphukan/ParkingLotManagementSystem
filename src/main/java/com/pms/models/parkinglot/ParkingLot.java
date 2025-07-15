package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.vehicle.Vehicle;
import com.pms.models.vehicle.VehicleTypePrice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLot extends BaseModel {

    private String address;

    private List<ParkingFloor> parkingFloors;

    private List<Gate> gates;

    private Map<Vehicle, VehicleTypePrice> vehicleTypePriceMap; //parking lot specific data
}
