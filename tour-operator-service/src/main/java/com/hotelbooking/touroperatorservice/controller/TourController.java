package com.hotelbooking.touroperatorservice.controller;

import com.hotelbooking.touroperatorservice.model.RoomAvailable;
import com.hotelbooking.touroperatorservice.model.Tour;
import com.hotelbooking.touroperatorservice.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }
    @PostMapping("/tours/{id}/add-city/{cityName}")
    public Tour addCityToTour(@PathVariable Long id, @PathVariable String cityName) {
        return tourService.addRoomsToTour(id,cityName);
    }

    @GetMapping("/tours/{id}")
    public Tour getTourById(@PathVariable Long id) {
        return tourService.getTourById(id);
    }

    @PostMapping("/tours")
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }
    @GetMapping("/tours/rooms/{tourId}")
    public Set<RoomAvailable> GetAllRooms(@PathVariable Long tourId) {
        return tourService.getRoomsByTourId(tourId);
    }
}
