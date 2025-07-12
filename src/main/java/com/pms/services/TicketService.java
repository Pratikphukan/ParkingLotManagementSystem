package com.pms.services;

import com.pms.models.Ticket;
import com.pms.models.parkinglot.Gate;
import com.pms.models.parkinglot.ParkingLot;
import com.pms.models.parkinglot.ParkingSpot;
import com.pms.models.vehicle.Vehicle;
import com.pms.repositories.ParkingLotRepository;
import com.pms.repositories.TicketRepository;
import com.pms.strategies.spotassignmentstrategy.ParkingSpotAssigningStrategy;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class TicketService {

    private static TicketService instance;

    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private ParkingSpotAssigningStrategy parkingSpotAssigningStrategy;

    private TicketService(ParkingLotRepository parkingLotRepository,
                          TicketRepository ticketRepository,
                          ParkingSpotAssigningStrategy parkingSpotAssigningStrategy) {
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotAssigningStrategy = parkingSpotAssigningStrategy;
    }

    public static TicketService getInstance(ParkingLotRepository parkingLotRepository,
                                            TicketRepository ticketRepository,
                                            ParkingSpotAssigningStrategy parkingSpotAssigningStrategy) {
        if (instance == null) {
            instance = new TicketService(parkingLotRepository,
                    ticketRepository,
                    parkingSpotAssigningStrategy);
        }
        return instance;
    }

    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, Gate entryGate) {
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        if (parkingLot == null) {
            throw new IllegalArgumentException("Parking lot not found with id: " + parkingLotId);
        }
        ParkingSpot parkingSpot = parkingSpotAssigningStrategy.assignParkingSpot(parkingLot, vehicle.getVehicleType(), entryGate);
        Ticket ticket = new Ticket(ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L));
        ticket.setEntryGate(entryGate);
        ticket.setOperator(entryGate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }
}
