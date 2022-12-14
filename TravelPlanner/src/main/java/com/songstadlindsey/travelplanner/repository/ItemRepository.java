package com.songstadlindsey.travelplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.songstadlindsey.travelplanner.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	  // get items by user Id
	@Query(value = "SELECT * FROM item WHERE user_id = ?1", nativeQuery = true)
	  List<Item> findUserItems(Long userId);
	
	// get items by trip Id
	@Query(value = "SELECT * FROM item WHERE trip_id = ?1", nativeQuery = true)
	  List<Item> findTripItems(Long userId);
}
