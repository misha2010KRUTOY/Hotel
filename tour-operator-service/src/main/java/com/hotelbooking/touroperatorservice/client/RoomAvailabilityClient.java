package com.hotelbooking.touroperatorservice.client;

import com.hotelbooking.touroperatorservice.model.Room;
import com.hotelbooking.touroperatorservice.model.RoomAvailable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-availability-service", url = "http://localhost:8081") // URL сервиса с отелями
public interface RoomAvailabilityClient {

    @GetMapping("/rooms/{city}")
    List<Room> getRoomsByCity(@PathVariable("city") String city);
}
