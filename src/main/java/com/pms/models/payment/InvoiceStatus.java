package com.pms.models.payment;

import lombok.Getter;

@Getter
public enum InvoiceStatus {

    PAID("paid"), UNPAID("unpaid");

    private final String invoiceStatus;

    InvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
