package com.pms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateParkingLotRequestDto {

    private String address;

    private Integer noOfParkingFloors;
}
