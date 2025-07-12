package com.pms.dtos;

import lombok.Getter;

@Getter
public enum ResponseStatusDto {

    SUCCESS("Success"),
    FAILURE("Failure"),
    ERROR("Error");

    private final String status;

    ResponseStatusDto(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseStatusDto{" +
                "status='" + status + '\'' +
                '}';
    }
}
