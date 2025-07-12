package com.pms.models.parkinglot;

import com.pms.models.BaseModel;
import com.pms.models.GateStatus;
import com.pms.models.GateType;
import com.pms.models.Operator;
import lombok.Getter;

@Getter
public abstract class Gate extends BaseModel {

    protected Integer gateNumber;

    protected Operator operator; //operator who manages the gate and it might change over time

    protected GateType gateType;

    protected GateStatus gateStatus;

    public Gate(Long id) {
        super(id);
    }
}
