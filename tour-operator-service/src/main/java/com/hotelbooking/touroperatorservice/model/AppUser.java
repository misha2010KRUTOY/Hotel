package com.hotelbooking.touroperatorservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;


@Entity
@Table(name = "users")
public class AppUser {
    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Getter
    private String firstName;
    private String lastName;

    @Getter
    @Column(unique = true)
    private String username;



    @Getter
    private String phone;
    @Getter
    private String address;
    @Getter
    private String password;
    @Getter
    private Date createdAt;

    public String getLastName(String lastName) {
        return this.lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
