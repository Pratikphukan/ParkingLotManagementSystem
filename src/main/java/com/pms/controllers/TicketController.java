package com.pms.controllers;

import com.pms.dtos.GenerateTicketRequestDto;
import com.pms.dtos.GenerateTicketResponseDto;
import com.pms.dtos.ResponseDto;
import com.pms.dtos.ResponseStatusDto;
import com.pms.services.TicketService;

public class TicketController {

    private static TicketController instance;

    private TicketService tiketService;

    private TicketController(TicketService ticketService) {
        this.tiketService = ticketService;
    }

    public static TicketController getInstance(TicketService ticketService) {
        if (instance == null) {
            instance = new TicketController(ticketService);
        }
        return instance;
    }

    public ResponseDto<GenerateTicketResponseDto> generateTicket(GenerateTicketRequestDto request) {
        // Logic to generate a ticket
        // This is a placeholder for the actual implementation
        return new ResponseDto<>(ResponseStatusDto.SUCCESS, "Ticket generated successfully", null);
    }
}
