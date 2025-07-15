package com.pms.repositories;

import com.pms.models.parkinglot.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private static ParkingLotRepository instance;

    private final Map<Long, ParkingLot> parkingLotStore = new HashMap<>();

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
        parkingLot.setId(lastCount);
        parkingLotStore.put(lastCount, parkingLot);
        return parkingLot;
    }

    public ParkingLot getById(Long id) {
        if (parkingLotStore.containsKey(id))
            return parkingLotStore.get(id);
        return null;
    }

    public ParkingLot update(ParkingLot parkingLot) {
        parkingLotStore.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
