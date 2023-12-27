package com.example.orderservice.entities;

import com.example.orderservice.enums.OderStatus;

import java.util.Date;

public interface orderProject {
    Long getId();
    Date getCreatedAt();
    Long getCustomerId();
    OderStatus getStatus();


}
