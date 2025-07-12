package com.pms.dtos;

import com.pms.models.parkinglot.Gate;
import com.pms.models.vehicle.Vehicle;
import lombok.Getter;

@Getter
public class GenerateTicketRequestDto {

    private Vehicle vehicle;

    private Gate entryGate;

    private Long parkingLotId;

    public GenerateTicketRequestDto(Vehicle vehicle, Gate entryGate, Long parkingLotId) {
        this.vehicle = vehicle;
        this.entryGate = entryGate;
        this.parkingLotId = parkingLotId;
    }
}
