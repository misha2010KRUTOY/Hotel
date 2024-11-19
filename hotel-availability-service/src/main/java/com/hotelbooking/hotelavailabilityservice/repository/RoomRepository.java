package com.hotelbooking.hotelavailabilityservice.repository;

import com.hotelbooking.hotelavailabilityservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByCity(String city);
    List<Room> findByIsAvailableTrue();
}
