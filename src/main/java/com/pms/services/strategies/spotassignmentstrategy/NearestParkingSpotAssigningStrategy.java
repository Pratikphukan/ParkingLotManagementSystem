package com.pms.services.strategies.spotassignmentstrategy;

import com.pms.models.parkinglot.Gate;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.models.parkinglot.ParkingSpot;
import com.pms.models.vehicle.VehicleType;

public class NearestParkingSpotAssigningStrategy implements ParkingSpotAssigningStrategy {

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate) {
        return null;
    }
}
