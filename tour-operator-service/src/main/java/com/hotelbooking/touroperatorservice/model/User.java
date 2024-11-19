package com.hotelbooking.touroperatorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    // Конструктор без ID для создания нового пользователя
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;

    }
}
