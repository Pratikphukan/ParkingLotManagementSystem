package com.pms.services;

import com.pms.models.Ticket;
import com.pms.models.parkinglot.Gate;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.models.parkinglot.ParkingSpot;
import com.pms.models.vehicle.Vehicle;
import com.pms.repositories.ParkingLotRepository;
import com.pms.repositories.TicketRepository;
import com.pms.services.factory.ParkingSpotAssigningStrategyFactory;
import com.pms.services.strategies.spotassignmentstrategy.ParkingSpotAssigningStrategy;

import java.time.LocalDateTime;

public class TicketService {

    private static TicketService instance;

    private final ParkingLotRepository parkingLotRepository;
    private final TicketRepository ticketRepository;
    private final ParkingSpotAssigningStrategy parkingSpotAssigningStrategy;

    private TicketService(String spotAssigningStrategy) {
        this.parkingLotRepository = ParkingLotRepository.getInstance();
        this.ticketRepository = TicketRepository.getInstance();
        this.parkingSpotAssigningStrategy = ParkingSpotAssigningStrategyFactory.getSpotAssignmentStrategy(spotAssigningStrategy);
    }

    public static TicketService getInstance(String spotAssigningStrategy) {
        if (instance == null) {
            instance = new TicketService(spotAssigningStrategy);
        }
        return instance;
    }

    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, Gate entryGate) {
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        if (parkingLot == null) {
            return null;
        }
        ParkingSpot parkingSpot = parkingSpotAssigningStrategy.assignParkingSpot(parkingLot, vehicle.getVehicleType(), entryGate);
        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setOperator(entryGate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }
}
