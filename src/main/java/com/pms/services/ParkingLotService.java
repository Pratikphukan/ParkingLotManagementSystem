package com.pms.services;

import com.pms.models.parkinglot.ParkingLot;
import com.pms.repositories.ParkingLotRepository;

import java.util.concurrent.ThreadLocalRandom;

public class ParkingLotService {

    private static ParkingLotService instance;

    private ParkingLotRepository parkingLotRepository;

    private ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public static ParkingLotService getInstance(ParkingLotRepository parkingLotRepository) {
        if (instance == null) {
            instance = new ParkingLotService(parkingLotRepository);
        }
        return instance;
    }

    public ParkingLot createParkingLot(String address) {
        ParkingLot parkingLot = new ParkingLot(ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L),
                address);
        return parkingLotRepository.save(parkingLot);
    }
}
