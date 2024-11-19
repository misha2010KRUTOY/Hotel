package com.hotelbooking.touroperatorservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room_available")
public class RoomAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String roomType;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "tour_id") // внешний ключ для связи с Tour
    @JsonIgnore  // Игнорируем сериализацию этого поля
    private Tour tour;
}
