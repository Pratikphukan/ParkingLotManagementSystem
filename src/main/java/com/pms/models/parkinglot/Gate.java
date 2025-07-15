package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.GateStatus;
import com.pms.models.GateType;
import com.pms.models.Operator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {

    private Integer gateNumber;

    private Operator operator; //operator who manages the gate and it might change over time

    private GateType gateType;

    private GateStatus gateStatus;
}
