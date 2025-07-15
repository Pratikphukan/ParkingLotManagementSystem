package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;

    private List<ParkingSpot> parkingSpots;
}
