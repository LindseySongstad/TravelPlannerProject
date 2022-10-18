package com.songstadlindsey.travelplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.entity.Item;
import com.songstadlindsey.travelplanner.entity.Trip;
import com.songstadlindsey.travelplanner.security.CustomUserDetails;
import com.songstadlindsey.travelplanner.service.ItemService;
import com.songstadlindsey.travelplanner.service.TripService;

// controller for Items

@Controller
public class ItemController {
	private static final String REDIRECT = "redirect:";
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private TripService tripService;
	
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
		return REDIRECT +"/trips/edit/{tripId}";
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
		existingItem.setAddress(item.getAddress());
		existingItem.setDayOfTrip(item.getDayOfTrip());
		existingItem.setDetails(item.getDetails());
		existingItem.setPriority(item.getPriority());
		
		// save updated item object
		itemService.updateItem(existingItem);
		return REDIRECT +"/trips";		
	}
	// delete item
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return REDIRECT +"/items";
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
