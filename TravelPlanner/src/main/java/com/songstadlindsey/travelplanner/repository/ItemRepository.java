package com.songstadlindsey.travelplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.songstadlindsey.travelplanner.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	  @Query(value = "SELECT * FROM item WHERE user_id = ?1", nativeQuery = true)
	  List<Item> findUserItems(Long userId);
}
