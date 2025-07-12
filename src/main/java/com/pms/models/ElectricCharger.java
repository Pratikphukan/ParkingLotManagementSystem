package com.pms.models;

import lombok.Getter;

@Getter
public class ElectricCharger extends BaseModel {

    private Integer consumption;

    public ElectricCharger(Long id) {
        super(id);
    }
}
