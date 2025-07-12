package com.pms.models;

import lombok.Getter;

@Getter
public enum GateStatus {

    OPEN("open"), CLOSED("closed");

    private final String gateStatus;

    GateStatus(String gateStatus) {
        this.gateStatus = gateStatus;
    }
}
