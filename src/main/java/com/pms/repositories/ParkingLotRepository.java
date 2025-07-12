package com.pms.repositories;

import com.pms.models.parkinglot.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private static ParkingLotRepository instance;

    private Map<Long, ParkingLot> parkingLotStore = new HashMap<>();
    private Long lastCount = 0L;

    private ParkingLotRepository() {
        // Private constructor to prevent instantiation
    }

    public static ParkingLotRepository getInstance() {
        if (instance == null) {
            instance = new ParkingLotRepository();
        }
        return instance;
    }

    public ParkingLot save(ParkingLot parkingLot) {
        lastCount += 1;
        parkingLotStore.put(lastCount, parkingLot);
        return parkingLot;
    }

    public ParkingLot getById(Long id) {
        return parkingLotStore.get(lastCount);
    }
}
