package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;

    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(Long id) {
        super(id);
    }
}
