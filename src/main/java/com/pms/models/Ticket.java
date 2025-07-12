package com.pms.models;

import com.pms.models.parkinglot.Gate;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.models.parkinglot.ParkingSpot;
import com.pms.models.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket extends BaseModel {

    private ParkingLot parkingLot;

    private ParkingSpot parkingSpot;

    private Gate entryGate;

    private LocalDateTime entryTime;

    private Vehicle vehicle;

    private String ownerName;

    private Operator operator;

    public Ticket(Long id) {
        super(id);
    }
}
