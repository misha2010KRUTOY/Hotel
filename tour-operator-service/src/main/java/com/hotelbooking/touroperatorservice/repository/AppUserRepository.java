package com.hotelbooking.touroperatorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotelbooking.touroperatorservice.model.AppUser;
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
    public AppUser findByUsername(String username);

}
