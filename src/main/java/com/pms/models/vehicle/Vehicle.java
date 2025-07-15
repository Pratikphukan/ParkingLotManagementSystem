package com.pms.models.vehicle;

import com.pms.models.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle extends BaseModel {

    private String vehicleNumber;

    private VehicleType vehicleType;
}
