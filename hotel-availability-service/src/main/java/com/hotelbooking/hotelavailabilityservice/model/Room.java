package com.hotelbooking.hotelavailabilityservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String roomType;
    private boolean isAvailable;
}
