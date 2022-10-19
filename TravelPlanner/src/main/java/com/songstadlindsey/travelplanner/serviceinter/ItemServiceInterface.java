package com.songstadlindsey.travelplanner.serviceinter;

import java.util.List;

import com.songstadlindsey.travelplanner.entity.Item;

public interface ItemServiceInterface {
	Item saveItem(Item Item);
	List<Item> getAllItems();
	Item getItemById(long id);
	Item updateItem(Item Item);
	void deleteItem(long id);
	List<Item> findUserItems(Long userId);
	List<Item> findTripItems(Long userId);
	
}
