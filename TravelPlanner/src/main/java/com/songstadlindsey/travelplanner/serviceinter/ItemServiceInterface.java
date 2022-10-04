package com.songstadlindsey.travelplanner.serviceinter;

import java.util.List;

import com.songstadlindsey.travelplanner.model.Item;

public interface ItemServiceInterface {
	Item saveItem(Item Item);
	List<Item> getAllItems();
	Item getItemById(long id);
	Item updateItem(Item Item);
	void deleteItem(long id);
}
