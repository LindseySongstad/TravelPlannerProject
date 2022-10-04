package com.songstadlindsey.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.songstadlindsey.travelplanner.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
