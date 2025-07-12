package com.pms.strategies.spotassignmentstrategy;

import com.pms.models.parkinglot.*;
import com.pms.models.vehicle.VehicleType;

public class RandomParkingSpotAssigningStrategy implements ParkingSpotAssigningStrategy {

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpot.getVehicleType().equals(vehicleType)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
