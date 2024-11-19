package com.hotelbooking.touroperatorservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String tourName;
    private String description;

    @OneToMany(mappedBy = "tour")  // Обратите внимание на 'mappedBy' для явного указания владельца связи
    @JsonIgnore  // Игнорируем сериализацию списка roomAvailables
    private Set<RoomAvailable> roomAvailables;

    private double price;
}
