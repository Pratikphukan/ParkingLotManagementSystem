package com.pms.controllers;

import com.pms.dtos.GenerateTicketRequestDto;
import com.pms.dtos.GenerateTicketResponseDto;
import com.pms.dtos.ResponseDto;
import com.pms.dtos.ResponseStatus;
import com.pms.models.Ticket;
import com.pms.services.TicketService;

public class TicketController {

    private static TicketController instance;

    private final TicketService ticketService;

    private TicketController(String spotAssignmentStrategy) {
        this.ticketService = TicketService.getInstance(spotAssignmentStrategy);
    }

    public static TicketController getInstance(String spotAssignmentStrategy) {
        if (instance == null) {
            instance = new TicketController(spotAssignmentStrategy);
        }
        return instance;
    }

    public ResponseDto<GenerateTicketResponseDto> generateTicket(GenerateTicketRequestDto request) {
        // Logic to generate a ticket
        // This is a placeholder for the actual implementation
        Ticket ticket = ticketService.generateTicket(request.getParkingLotId(), request.getVehicle(), request.getEntryGate());
        return new ResponseDto<>(ResponseStatus.SUCCESS,
                "Ticket generated successfully",
                new GenerateTicketResponseDto(ticket));
    }
}
