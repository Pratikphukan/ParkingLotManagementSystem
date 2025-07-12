package com.pms.models.vehicle;

import com.pms.models.BaseModel;
import lombok.Getter;

@Getter
public class Vehicle extends BaseModel {

    private String vehicleNumber;

    private VehicleType vehicleType;

    public Vehicle(Long id) {
        super(id);
    }
}
