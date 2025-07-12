package com.pms.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    protected Long id;

    @Setter
    protected LocalDateTime createdDate;

    @Setter
    protected LocalDateTime lastUpdatedDate;

    @Setter
    protected boolean isDeleted;

    public BaseModel(Long id) {
        this.id = id;
    }

    public BaseModel(Long id, LocalDateTime createdDate, LocalDateTime lastUpdatedDate) {
        this(id);
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
