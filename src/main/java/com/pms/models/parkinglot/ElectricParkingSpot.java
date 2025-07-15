package com.pms.models.parkinglot;

import com.pms.models.ElectricCharger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricParkingSpot extends ParkingSpot {

    private ElectricCharger electricCharger;
}
