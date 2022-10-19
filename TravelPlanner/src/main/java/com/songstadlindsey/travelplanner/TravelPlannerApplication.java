package com.songstadlindsey.travelplanner;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.songstadlindsey.travelplanner.entity.Item;
import com.songstadlindsey.travelplanner.entity.Trip;
import com.songstadlindsey.travelplanner.enums.Category;
import com.songstadlindsey.travelplanner.repository.ItemRepository;
import com.songstadlindsey.travelplanner.repository.TripRepository;

@SpringBootApplication
public class TravelPlannerApplication implements CommandLineRunner{

	@Autowired
    private TripRepository tripRepository;
	

	@Override
    public void run(String...args) throws Exception {
		// Sample trip Italy
		
//		Trip trip1 = new Trip("Italy", "Demo One week trip to Italy", 7);
//		trip1.setUserId(11);
//		// Day 1
//		trip1.addTripItem(new Item( (long) 11, "Flight", Category.Transportation, "flight to Rome", "address", 1));
//		// day 2
//		trip1.addTripItem( new Item((long) 11, "Hotel in Rome", Category.Accommodations, "details", "address", 2));
//		trip1.addTripItem( new Item((long) 11,"Colloseum", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem( new Item((long)11, "Pantheon", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem(new Item( (long)11,"Lunch", Category.Food, "details", "address", 2));
//		trip1.addTripItem( new Item((long)11, "Spanish Steps", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem(new Item((long)11,"Dinner", Category.Food, "details", "address", 2));		
//		// day 3
//		trip1.addTripItem( new Item((long)11, "Hotel in Rome", Category.Accommodations, "details", "address", 3));
//		trip1.addTripItem( new Item((long)11,"Vatican", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem(new Item((long)11, "Lunch", Category.Food, "details", "address", 3));
//		trip1.addTripItem( new Item((long)11, "Pantheon", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem( new Item( (long)11,"Spanish Steps", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem(new Item( (long)11,"Dinner", Category.Food, "details", "address", 3));
//		// day 4
//		trip1.addTripItem( new Item( (long)11,"Hotel in Rome", Category.Accommodations, "details", "address", 4));
//		trip1.addTripItem(new Item((long)11, "Train", Category.Transportation, "train to Florence", "address", 4));
//		trip1.addTripItem(new Item( (long)11,"Dinner", Category.Food, "details", "address", 4));
//		// day 5
//		trip1.addTripItem( new Item((long)11, "Hotel in Florence", Category.Accommodations, "details", "address", 5));
//		trip1.addTripItem( new Item((long)11, "Florence Cathedral", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem( new Item( (long)11,"Florence Baptistry", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem(new Item((long)11, "Lunch", Category.Food, "details", "address", 5));
//		trip1.addTripItem( new Item( (long)11,"Uffizi", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem(new Item((long)11, "Dinner", Category.Food, "details", "address", 5));
//		// day 6
//		trip1.addTripItem( new Item((long)11, "Hotel in Florence", Category.Accommodations, "details", "address", 6));
//		trip1.addTripItem( new Item((long)11, "Boboli Gardens", Category.Attraction, "details", "address", 6));
//		trip1.addTripItem(new Item((long) 11,"Lunch", Category.Food, "details", "address", 6));
//		trip1.addTripItem( new Item((long)11, "Duomo", Category.Attraction, "details", "address", 6));;
//		trip1.addTripItem(new Item((long)11, "Dinner", Category.Food, "details", "address", 6));
//		// day 7 
//		trip1.addTripItem(new Item( (long)11,"Flight", Category.Transportation, "flight home", "address", 7));
//		trip1.addTripItem(new Item((long)11, "Home", Category.None, "", "", 7));
//		tripRepository.save(trip1);	
    
	}
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
