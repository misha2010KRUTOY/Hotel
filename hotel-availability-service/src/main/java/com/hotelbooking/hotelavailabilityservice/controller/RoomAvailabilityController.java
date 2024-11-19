package com.hotelbooking.hotelavailabilityservice.controller;

import com.hotelbooking.hotelavailabilityservice.model.Room;
import com.hotelbooking.hotelavailabilityservice.service.RoomAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomAvailabilityController {

    @Autowired
    private RoomAvailabilityService roomAvailabilityService;

    @GetMapping("/rooms")
    public List<Room> getAvailableRooms() {
        return roomAvailabilityService.getAvailableRooms();
    }

    @GetMapping("/rooms/{city}")
    public List<Room> getRoomsByCity(@PathVariable String city) {
        return roomAvailabilityService.getRoomsByCity(city);
    }

    // Метод для создания комнаты
    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) {
        return roomAvailabilityService.createRoom(room);
    }
}
