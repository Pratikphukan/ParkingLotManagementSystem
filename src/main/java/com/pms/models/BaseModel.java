package com.pms.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseModel {

    @Id
    protected Long id;

    protected LocalDateTime createdDate;

    protected LocalDateTime lastUpdatedDate;

    protected boolean isDeleted;
}
