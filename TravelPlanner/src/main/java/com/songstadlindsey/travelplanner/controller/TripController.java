package com.songstadlindsey.travelplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.model.Trip;
import com.songstadlindsey.travelplanner.service.ItemService;
import com.songstadlindsey.travelplanner.service.TripService;

@Controller
public class TripController {
	private TripService tripService;

	
	public TripController(TripService tripService) {
		super();
		this.tripService = tripService;
	}
	// list all trips
	@GetMapping("/trips")
	public String listTrips(Model model) {
		model.addAttribute("trips", tripService.getAllTrips());
		return "trips";
	}
	// add new trip form
	@GetMapping("/trips/new")
	public String createTripForm(Model model) {
		Trip trip = new Trip();
		model.addAttribute("trip", trip);
		return "create_trip";
	}
	// post new trip
	@PostMapping("/trips")
	public String saveTrip(@ModelAttribute("trip") Trip trip) {
		tripService.saveTrip(trip);
		return "redirect:/trips";
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
		//	@ModelAttribute("trip") Trip trip,
			@ModelAttribute("item") Item item,
			Model model) {
		Trip existingTrip = tripService.getTripById(id);
		existingTrip.setId(id);
		existingTrip.addTripItem(item);
		tripService.updateTrip(existingTrip);
		return "redirect:/trips/edit/{id}";
	}
	
	// delete trip
	@GetMapping("/trips/{id}")
	public String deleteTrip(@PathVariable Long id) {
		tripService.deleteTrip(id);
		return "redirect:/trips";
	}
}
