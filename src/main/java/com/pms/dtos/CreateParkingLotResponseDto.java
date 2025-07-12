package com.pms.dtos;

import com.pms.models.parkinglot.ParkingLot;
import lombok.Getter;

@Getter
public class CreateParkingLotResponseDto {

    private ParkingLot parkingLot;

    public CreateParkingLotResponseDto(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

}
