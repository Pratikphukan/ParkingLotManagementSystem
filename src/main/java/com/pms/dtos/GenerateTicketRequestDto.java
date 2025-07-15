package com.pms.dtos;

import com.pms.models.parkinglot.Gate;
import com.pms.models.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenerateTicketRequestDto {

    private Vehicle vehicle;

    private Gate entryGate;

    private Long parkingLotId;
}
