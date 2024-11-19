package com.hotelbooking.touroperatorservice.repository;

import com.hotelbooking.touroperatorservice.model.RoomAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoomAvailableRepository extends JpaRepository<RoomAvailable,Long> {
    Set<RoomAvailable> findAllByTourId(Long tourId);

}
