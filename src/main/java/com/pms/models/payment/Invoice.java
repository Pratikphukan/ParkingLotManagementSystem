package com.pms.models.payment;

import com.pms.models.BaseModel;
import com.pms.models.Operator;
import com.pms.models.Ticket;
import com.pms.models.parkinglot.Gate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Invoice extends BaseModel {

    private Ticket ticket;

    private Double amount;

    private LocalDateTime exitTime;

    private Operator operator;

    private InvoiceStatus invoiceStatus;

    private Gate exitGate;

    private List<Payment> payments;
}
