package com.songstadlindsey.travelplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.songstadlindsey.travelplanner.entity.Item;
import com.songstadlindsey.travelplanner.entity.Trip;
import com.songstadlindsey.travelplanner.entity.User;
import com.songstadlindsey.travelplanner.service.UserService;

// controller for users

@Controller
public class UserController {
	private static final String REDIRECT = "redirect:";
	
	@Autowired
	private UserService userService;
	
	// edit user form
	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";	
	}
	// post edit user
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model) {
		
		// get user from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		// save updated user object
		userService.updateUser(existingUser);
		return REDIRECT +"/users";		
	}
	// add trip form
	@GetMapping("/user/addtrip/{id}")
	public String addTripForm(@PathVariable Long id, 
			@AuthenticationPrincipal UserDetails userDetails,
			Model model) {
		String email = userDetails.getUsername();
    	User user = userService.findUserByEmail(email);
    	model.addAttribute("user", user);
		model.addAttribute("trip", userService.getUserById(id));
		Trip trip = new Trip();
		model.addAttribute("trip", trip);
		return "create_trip";	
	}
	// post add trip 
	@PostMapping("/user/addtrip{id}")
	public String saveTrip(@PathVariable Long id,
			@ModelAttribute("trip") Trip trip,
			//@AuthenticationPrincipal UserDetails userDetails,
			Model model) {
//    	String email = userDetails.getUsername();
//    	User user = userService.findUserByEmail(email);
//    	model.addAttribute("user", user);
		User currentUser = userService.getUserById(id);
		currentUser.setId(id);
		currentUser.addTrip(trip);
		userService.updateUser(currentUser);
		return REDIRECT +"/items";
	}
	
	// delete user
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return REDIRECT +"/users";
	}
	
//	replaced in auth controller
	
//	@GetMapping("/users")
//	public String listUsers(Model model) {
//		model.addAttribute("users", userService.getAllUsers());
//		return "users";
//	}
	
//	@GetMapping("/users/new")
//	public String createUserForm(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "create_user";
//	}
	
//	@PostMapping("/users")
//	public String saveUser(@ModelAttribute("user") User user) {
//		userService.saveUser(user);
//		return "redirect:/users";
//	}
}
