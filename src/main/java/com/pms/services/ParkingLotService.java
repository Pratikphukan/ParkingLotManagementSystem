package com.pms.services;

import com.pms.dtos.CreateParkingLotRequestDto;
import com.pms.dtos.UpdateParkingLotRequestDto;
import com.pms.models.parkinglot.ParkingFloor;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.repositories.ParkingLotRepository;

import java.util.ArrayList;

public class ParkingLotService {

    private static ParkingLotService instance;

    private final ParkingLotRepository parkingLotRepository;

    private ParkingLotService() {
        this.parkingLotRepository = ParkingLotRepository.getInstance();
    }

    public static ParkingLotService getInstance() {
        if (instance == null) {
            instance = new ParkingLotService();
        }
        return instance;
    }

    public ParkingLot createParkingLot(CreateParkingLotRequestDto createParkingLotRequestDto) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingFloors(new ArrayList<>());
        for (int i = 0; i < createParkingLotRequestDto.getNoOfParkingFloors(); i++) {
            parkingLot.getParkingFloors().add(new ParkingFloor());
        }
        parkingLot.setAddress(createParkingLotRequestDto.getAddress());
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot updateParkingLot(UpdateParkingLotRequestDto updateParkingLotRequestDto) {
        ParkingLot parkingLot = parkingLotRepository.getById(updateParkingLotRequestDto.getParkingLotId());
        if (parkingLot == null) {
            return null;
        }
        parkingLot.setAddress(updateParkingLotRequestDto.getAddress());
        return parkingLotRepository.update(parkingLot);
    }
}
