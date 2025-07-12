package com.pms.models.vehicle;

import com.pms.models.BaseModel;
import lombok.Getter;

import java.util.Map;

@Getter
public class VehicleTypePrice extends BaseModel {

    private Long basePrice;

    private Map<Integer, Long> multiplier;

    public VehicleTypePrice(Long id) {
        super(id);
    }
}
