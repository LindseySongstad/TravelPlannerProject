package com.songstadlindsey.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.songstadlindsey.travelplanner.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
