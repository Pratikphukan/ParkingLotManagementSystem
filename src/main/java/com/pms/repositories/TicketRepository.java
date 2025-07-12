package com.pms.repositories;

import com.pms.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private static TicketRepository instance;

    private Long lastCount = 0L;
    private Map<Long, Ticket> ticketStore = new HashMap<>();

    private TicketRepository() {
        // Private constructor to prevent instantiation
    }

    public static TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }

    public Ticket save(Ticket ticket) {
        lastCount += 1;
        ticketStore.put(lastCount, ticket);
        return ticket;
    }
}
