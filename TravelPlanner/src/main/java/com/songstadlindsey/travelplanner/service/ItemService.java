package com.songstadlindsey.travelplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.entity.Item;
import com.songstadlindsey.travelplanner.repository.ItemRepository;
import com.songstadlindsey.travelplanner.serviceinter.ItemServiceInterface;


@Service
public class ItemService implements ItemServiceInterface {
	@Autowired
	private ItemRepository itemRepository;
	
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
	@Override
	public List<Item> findUserItems(Long userId){
		return itemRepository.findUserItems(userId);
	}

	@Override
	public List<Item> findTripItems(Long userId) {
		return itemRepository.findTripItems(userId);
	};
}
