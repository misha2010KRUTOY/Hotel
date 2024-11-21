package com.hotelbooking.touroperatorservice.service;

import com.hotelbooking.touroperatorservice.client.RoomAvailabilityClient;
import com.hotelbooking.touroperatorservice.model.Room;
import com.hotelbooking.touroperatorservice.model.RoomAvailable;
import com.hotelbooking.touroperatorservice.model.Tour;
import com.hotelbooking.touroperatorservice.repository.RoomAvailableRepository;
import com.hotelbooking.touroperatorservice.repository.TourRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private RoomAvailabilityClient roomAvailabilityClient;
    @Autowired
    private RoomAvailableRepository roomAvailableRepository;

    // Метод для создания нового тура
    public Tour createTour(Tour tour) {
        // Сохраняем тур в базе данных
        Tour savedTour = tourRepository.save(tour);

        // Сохраняем тур с фномерами
        return tourRepository.save(savedTour);
    }

    // Метод для добавления номеров в уже существующий тур
    public Tour addRoomsToTour(Long tourId,String city) {
        // Получаем существующий тур по ID
        Tour tour = tourRepository.findById(tourId).orElse(null);

        if (tour == null) {
            // Если тур не найден, возвращаем null или бросаем исключение
            return null;
        }

        // Получаем доступные номера для города, в котором проводится тур
        List<Room> rooms = roomAvailabilityClient.getRoomsByCity(city);
        Tour tourToSave = tourRepository.findById(tourId).orElse(null);
        for (Room room: rooms) {
            RoomAvailable roomAvailable = new RoomAvailable();
            roomAvailable.setTour(tour);
            roomAvailable.setRoomType(room.getRoomType());
            roomAvailable.setCity(room.getCity());
            RoomAvailable savedRoom = roomAvailableRepository.save(roomAvailable);
            log.info("Roomd dsved "+ savedRoom);
            tourToSave.setRoomAvailables(new HashSet<>(Set.of(savedRoom)));

        }

        // Сохраняем обновлённый тур
        return tourRepository.save(tourToSave);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public Set<RoomAvailable> getRoomsByTourId(Long tourId) {
        Tour tour = tourRepository.findById(tourId).orElse(null);
        return roomAvailableRepository.findAllByTourId(tourId);
    }
}
