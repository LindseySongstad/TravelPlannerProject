package com.songstadlindsey.travelplanner.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.model.Trip;
import com.songstadlindsey.travelplanner.model.User;
import com.songstadlindsey.travelplanner.security.CustomUserDetails;
import com.songstadlindsey.travelplanner.service.ItemService;
import com.songstadlindsey.travelplanner.service.TripService;
import com.songstadlindsey.travelplanner.service.UserService;

@Controller
public class TripController {
	private TripService tripService;
	private UserService userService;

	
	public TripController(TripService tripService, UserService userService) {
		super();
		this.tripService = tripService;
		this.userService = userService;
	}
//	// list all trips
//	@GetMapping("/trips")
//	public String listTrips(Model model) {
//		model.addAttribute("trips", tripService.getAllTrips());
//		return "trips";
//	}
	// list user trips
	@GetMapping("/trips")
	public String listTrips(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		Long userId = userDetails.getId();
		model.addAttribute("trips", tripService.findUserTrips(userId));
		return "trips";
	}

	// edit trip form
	@GetMapping("/trips/edit/{id}")
	public String editTripForm(@PathVariable Long id, Model model) {
		model.addAttribute("trip", tripService.getTripById(id));
		return "edit_trip";	
	}
	// post edit trip
	@PostMapping("/trips/{id}")
	public String updateTrip(@PathVariable Long id,
			@ModelAttribute("trip") Trip trip,
			Model model) {
		
		// get trip from database by id
		Trip existingTrip = tripService.getTripById(id);
		existingTrip.setId(id);
		existingTrip.setName(trip.getName());
		existingTrip.setTripLength(trip.getTripLength());

		// save updated trip object
		tripService.updateTrip(existingTrip);
		return "redirect:/trips";		
	}
	
	// add trip item form
	@GetMapping("/trips/add/{id}")
	public String addTripItemForm(@PathVariable Long id, Model model) {
		model.addAttribute("trip", tripService.getTripById(id));
		Item item = new Item();
		model.addAttribute("item", item);
		return "create_item";	
	}
	// post add trip item
	@PostMapping("/trips/add/{id}")
	public String saveItem(@PathVariable Long id,
			@ModelAttribute("item") Item item,
			Model model) {
		Trip existingTrip = tripService.getTripById(id);
		existingTrip.setId(id);
		existingTrip.addTripItem(item);
		tripService.updateTrip(existingTrip);
		return "redirect:/trips/edit/{id}";
	}
	// add user trip form
	@GetMapping("/trip/new/{userId}")
	public String addTripForm(@PathVariable Long userId, 
			Model model) {
    	User user = userService.getUserById(userId);
    	model.addAttribute("user", user);
		Trip trip = new Trip();
		model.addAttribute("trip", trip);
		return "create_trip";	
	}
	// post add user trip 
	@PostMapping("/trip/new/{userId}")
	public String saveTrip(@PathVariable Long userId,
			@ModelAttribute("trip") Trip trip,
			Model model) {
		trip.setUserId(userId);
		tripService.saveTrip(trip);
		return "redirect:/trips";
	}
	// delete trip
	@GetMapping("/trips/{id}")
	public String deleteTrip(@PathVariable Long id) {
		tripService.deleteTrip(id);
		return "redirect:/trips";
	}
	
	// without user
//	// add new trip form
//	@GetMapping("/trips/new")
//	public String createTripForm(Model model) {
//		Trip trip = new Trip();
//		model.addAttribute("trip", trip);
//		return "create_trip";
//	}
//	// post new trip
//	@PostMapping("/trips")
//	public String saveTrip(@ModelAttribute("trip") Trip trip) {
//		tripService.saveTrip(trip);
//		return "redirect:/trips";
//	}
}
