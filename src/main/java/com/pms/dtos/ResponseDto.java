package com.pms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponseDto<T> {

    private ResponseStatus status;

    private String message;

    private T data;
}
