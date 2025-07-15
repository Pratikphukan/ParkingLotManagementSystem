package com.pms.controllers;

import com.pms.dtos.*;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.services.ParkingLotService;

public class ParkingLotController {

    private static ParkingLotController instance;

    private final ParkingLotService parkingLotService;

    private ParkingLotController() {
        this.parkingLotService = ParkingLotService.getInstance();
    }

    public static ParkingLotController getInstance() {
        if (instance == null) {
            instance = new ParkingLotController();
        }
        return instance;
    }

    public ResponseDto<CreateParkingLotResponseDto> createParkingLot(CreateParkingLotRequestDto request) {
        if (request.getNoOfParkingFloors() < 2) {
            return new ResponseDto<>(ResponseStatus.FAILURE, "Parking lot must have at least 2 floors", null);
        }
        ParkingLot parkingLot = parkingLotService.createParkingLot(request);
        return new ResponseDto<>(ResponseStatus.SUCCESS,
                "Parking lot created successfully",
                new CreateParkingLotResponseDto(parkingLot));
    }

    public ResponseDto<UpdateParkingLotResponseDto> updateParkingLot(UpdateParkingLotRequestDto request) {
        ParkingLot updatedParkingLot = parkingLotService.updateParkingLot(request);
        if (updatedParkingLot == null) {
            return new ResponseDto<>(ResponseStatus.FAILURE, "Parking lot not found with ID: " + request.getParkingLotId(), null);
        }
        return new ResponseDto<>(ResponseStatus.SUCCESS,
                "Parking lot updated successfully",
                new UpdateParkingLotResponseDto(updatedParkingLot));
    }
}
