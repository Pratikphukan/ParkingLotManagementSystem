package com.pms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateParkingLotRequestDto {

    private Long parkingLotId;

    private String address;
}
