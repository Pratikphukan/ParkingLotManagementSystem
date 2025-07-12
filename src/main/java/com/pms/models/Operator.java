package com.pms.models;

import lombok.Getter;

@Getter
public class Operator extends BaseModel {

    private String name;

    public Operator(Long id) {
        super(id);
    }
}
