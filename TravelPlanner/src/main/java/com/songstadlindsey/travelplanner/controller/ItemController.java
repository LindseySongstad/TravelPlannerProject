package com.songstadlindsey.travelplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.service.ItemService;

@Controller
public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public String listItems(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		return "items";
	}
	
	@GetMapping("/items/new")
	public String createItemForm(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "create_item";
	}
	
	@PostMapping("/items")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}
	
	@GetMapping("/items/edit/{id}")
	public String editItemForm(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "edit_item";	
	}
	
	@PostMapping("/items/{id}")
	public String updateItem(@PathVariable Long id,
			@ModelAttribute("item") Item item,
			Model model) {
		
		// get item from database by id
		Item existingItem = itemService.getItemById(id);
		existingItem.setId(id);
		existingItem.setName(item.getName());
		existingItem.setCategory(item.getCategory());
		// TO DO
		// finish attributes
		
		// save updated item object
		itemService.updateItem(existingItem);
		return "redirect:/items";		
	}
	
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return "redirect:/items";
	}
}
