package com.pms.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class ResponseDto<T> {

    private ResponseStatusDto status;

    private String message;

    private T data;

    public ResponseDto(ResponseStatusDto status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
