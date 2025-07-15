package com.pms.dtos;

import com.pms.models.parkinglot.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateParkingLotResponseDto {

    private ParkingLot parkingLot;
}
