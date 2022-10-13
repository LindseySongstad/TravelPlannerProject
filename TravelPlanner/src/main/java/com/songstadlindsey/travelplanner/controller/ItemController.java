package com.songstadlindsey.travelplanner.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.model.Trip;
import com.songstadlindsey.travelplanner.security.CustomUserDetails;
import com.songstadlindsey.travelplanner.service.ItemService;
import com.songstadlindsey.travelplanner.service.TripService;

@Controller
public class ItemController {
	private ItemService itemService;
	private TripService tripService;
	
	public ItemController(ItemService itemService, TripService tripService) {
		super();
		this.itemService = itemService;
		this.tripService = tripService;
	}
	// add trip item form
	@GetMapping("/item/new/{tripId}")
	public String addTripItemForm(@PathVariable Long tripId, Model model) {
		model.addAttribute("trip", tripService.getTripById(tripId));
		Item item = new Item();
		model.addAttribute("item", item);
		return "create_item";	
	}
	// post add trip item
	@PostMapping("/item/new/{tripId}")
	public String saveItem(@PathVariable Long tripId,
			@ModelAttribute("item") Item item,
			@AuthenticationPrincipal CustomUserDetails userDetails,
			Model model) {
		item.setUserId(userDetails.getId());
		Trip existingTrip = tripService.getTripById(tripId);
		existingTrip.setId(tripId);
		existingTrip.addTripItem(item);
		tripService.updateTrip(existingTrip);
		return "redirect:/trips/edit/{tripId}";
	}
	// list user items
	@GetMapping("/items")
	public String listItems(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		Long userId = userDetails.getId();
		model.addAttribute("items", itemService.findUserItems(userId));
		return "items";
	}
	// edit item form
	@GetMapping("/items/edit/{id}")
	public String editItemForm(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "edit_item";	
	}
	// post edit item
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
	// delete item
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return "redirect:/items";
	}
	
	
	// without user attached
	
//	// list all items
//	@GetMapping("/items")
//	public String listItems(Model model) {
//		model.addAttribute("items", itemService.getAllItems());
//		return "items";
//	}
	// new item form
//	@GetMapping("/items/new")
//	public String createItemForm(Model model) {
//		Item item = new Item();
//		model.addAttribute("item", item);
//		return "create_item";
//	}
//	// post new item
//	@PostMapping("/items")
//	public String saveItem(@ModelAttribute("item") Item item, 
//			@AuthenticationPrincipal CustomUserDetails userDetails) {
//		item.setUserId(userDetails.getId());
//		itemService.saveItem(item);
//		return "redirect:/items";
//	}
}
