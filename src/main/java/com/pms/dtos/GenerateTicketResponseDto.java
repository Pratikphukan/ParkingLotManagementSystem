package com.pms.dtos;

import com.pms.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenerateTicketResponseDto {

    private Ticket ticket;
}
