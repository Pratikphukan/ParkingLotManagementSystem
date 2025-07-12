package com.pms.controllers;

import com.pms.dtos.CreateParkingLotRequestDto;
import com.pms.dtos.CreateParkingLotResponseDto;
import com.pms.dtos.ResponseDto;
import com.pms.dtos.ResponseStatusDto;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.services.ParkingLotService;

public class ParkingLotController {

    private static ParkingLotController instance;

    private ParkingLotService parkingLotService;

    private ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public static ParkingLotController getInstance(ParkingLotService parkingLotService) {
        if (instance == null) {
            instance = new ParkingLotController(parkingLotService);
        }
        return instance;
    }

    public ResponseDto<CreateParkingLotResponseDto> createParkingLot(CreateParkingLotRequestDto request) {
        ParkingLot parkingLot = parkingLotService.createParkingLot(request.getAddress());
        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto(parkingLot);
        return new ResponseDto<>(ResponseStatusDto.SUCCESS, "Parking lot created successfully", response);
    }
}
