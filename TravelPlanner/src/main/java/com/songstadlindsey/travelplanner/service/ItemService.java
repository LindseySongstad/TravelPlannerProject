package com.songstadlindsey.travelplanner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.repository.ItemRepository;
import com.songstadlindsey.travelplanner.serviceinter.ItemServiceInterface;


@Service
public class ItemService implements ItemServiceInterface {
	private ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(long id) {
		itemRepository.deleteById(id);
	}
}
