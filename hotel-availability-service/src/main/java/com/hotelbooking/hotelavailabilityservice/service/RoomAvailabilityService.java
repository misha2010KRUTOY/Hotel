package com.hotelbooking.hotelavailabilityservice.service;

import com.hotelbooking.hotelavailabilityservice.model.Room;
import com.hotelbooking.hotelavailabilityservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAvailabilityService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAvailableRooms() {
        return roomRepository.findAll(); // Возвращаем все доступные комнаты
    }

    public List<Room> getRoomsByCity(String city) {
        return roomRepository.findByCity(city); // Возвращаем комнаты по городу
    }

    // Метод для создания комнаты
    public Room createRoom(Room room) {
        return roomRepository.save(room); // Сохраняем комнату в базе данных
    }
}
