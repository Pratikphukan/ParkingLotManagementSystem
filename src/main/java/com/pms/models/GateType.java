package com.pms.models;

import lombok.Getter;

@Getter
public enum GateType {

    ENTRY("entry"), EXIT("exit");

    // You can add methods or properties if needed in the future

    private final String gateType;

    GateType(String gateType) {
        this.gateType = gateType;
    }
}
