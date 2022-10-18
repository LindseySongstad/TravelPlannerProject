package com.songstadlindsey.travelplanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.songstadlindsey.travelplanner.entity.Item;
import com.songstadlindsey.travelplanner.entity.Trip;
import com.songstadlindsey.travelplanner.entity.User;
import com.songstadlindsey.travelplanner.enums.Category;
import com.songstadlindsey.travelplanner.service.ItemService;
import com.songstadlindsey.travelplanner.service.TripService;
import com.songstadlindsey.travelplanner.service.UserService;

@SpringBootTest
class TravelPlannerApplicationTests {
	@Autowired
	private ItemService itemService;	
	@Autowired
	private TripService tripService;
	@Autowired
	private UserService userService;
	
	//test get item by id from Item Service
	@Test 
	void testgetItemById() {
		Item expected = new Item( "testItem", Category.None, "testDetails", "testAddress", 7);
		expected.setId(294);
		expected.setUserId(11);
		Item actual = itemService.getItemById(294);
		assertEquals(expected, actual);
	}
	//test get trip by id from Trip Service
	@Test
	void testGetTripById() {
		Trip expected = new Trip(293, "testTrip",11, "testDescription", 7);
		Trip actual = tripService.getTripById(293);
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getTripLength(), actual.getTripLength());
		assertEquals(expected.getDescription(), actual.getDescription());
	}
	// test get user by id from User Service
	@Test
	void testGetUserById() {
		User expected = new User();
		expected.setEmail("potter@hotmail.com");
		expected.setFirstName("Harry ");
		expected.setLastName("Potter");
		expected.setId(1);
		User actual = userService.getUserById(1);
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getId(), actual.getId());	
	}
	// test find user items
	@ParameterizedTest
	@ValueSource(longs = {294, 295, 296})
	void testFindUserItems(long expectedId) {
		List<Item> userItems = itemService.findUserItems((long) 11);
		Item expected = itemService.getItemById(expectedId);
		assertTrue(userItems.contains(expected));
	}
	
	// test find user trips
	@Test
	void testFindUserTrips() {
		List<Trip> userTrips = tripService.findUserTrips((long) 11);
		long expectedId = 293;
		long actualId = userTrips.get(0).getId();
		assertEquals(expectedId,actualId);
	}
}
