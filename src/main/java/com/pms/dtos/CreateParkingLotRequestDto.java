package com.pms.dtos;

import lombok.Getter;

@Getter
public class CreateParkingLotRequestDto {

    private String address;

    private Integer noOfParkingFloors;

    public CreateParkingLotRequestDto(String address, Integer noOfParkingFloors) {
        this.address = address;
        this.noOfParkingFloors = noOfParkingFloors;
    }
}
