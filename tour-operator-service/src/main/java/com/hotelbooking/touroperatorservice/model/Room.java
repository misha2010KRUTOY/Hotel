package com.hotelbooking.touroperatorservice.model;

import lombok.Data;

@Data
public class Room {
    private Long id;
    private String city;
    private String roomType;
    private boolean isAvailable;
}
