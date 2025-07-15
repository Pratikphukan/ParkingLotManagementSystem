package com.pms.models.vehicle;

import com.pms.models.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class VehicleTypePrice extends BaseModel {

    private Long basePrice;

    private Map<Integer, Long> multiplier;
}
