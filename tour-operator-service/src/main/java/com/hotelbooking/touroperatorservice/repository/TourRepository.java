package com.hotelbooking.touroperatorservice.repository;

import com.hotelbooking.touroperatorservice.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByCity(String city);
}
