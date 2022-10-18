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
		
//		Trip trip1 = new Trip("Italy", "One week trip to Italy", 7);
//		trip1.setUserId(8);
//		// Day 1
//		trip1.addTripItem(new Item( "Flight", Category.Transportation, "flight to Rome", "address", 1));
//		// day 2
//		trip1.addTripItem( new Item( "Hotel in Rome", Category.Accommodations, "details", "address", 2));
//		trip1.addTripItem( new Item( "Colloseum", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem( new Item( "Pantheon", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem(new Item( "Lunch", Category.Food, "details", "address", 2));
//		trip1.addTripItem( new Item( "Spanish Steps", Category.Attraction, "details", "address", 2));
//		trip1.addTripItem(new Item( "Dinner", Category.Food, "details", "address", 2));		
//		// day 3
//		trip1.addTripItem( new Item( "Hotel in Rome", Category.Accommodations, "details", "address", 3));
//		trip1.addTripItem( new Item( "Vatican", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem(new Item( "Lunch", Category.Food, "details", "address", 3));
//		trip1.addTripItem( new Item( "Pantheon", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem( new Item( "Spanish Steps", Category.Attraction, "details", "address", 3));
//		trip1.addTripItem(new Item( "Dinner", Category.Food, "details", "address", 3));
//		// day 4
//		trip1.addTripItem( new Item( "Hotel in Rome", Category.Accommodations, "details", "address", 4));
//		trip1.addTripItem(new Item( "Train", Category.Transportation, "train to Florence", "address", 4));
//		trip1.addTripItem(new Item( "Dinner", Category.Food, "details", "address", 4));
//		// day 5
//		trip1.addTripItem( new Item( "Hotel in Florence", Category.Accommodations, "details", "address", 5));
//		trip1.addTripItem( new Item( "Florence Cathedral", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem( new Item( "Florence Baptistry", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem(new Item( "Lunch", Category.Food, "details", "address", 5));
//		trip1.addTripItem( new Item( "Uffizi", Category.Attraction, "details", "address", 5));
//		trip1.addTripItem(new Item( "Dinner", Category.Food, "details", "address", 5));
//		// day 6
//		trip1.addTripItem( new Item( "Hotel in Florence", Category.Accommodations, "details", "address", 6));
//		trip1.addTripItem( new Item( "Boboli Gardens", Category.Attraction, "details", "address", 6));
//		trip1.addTripItem(new Item( "Lunch", Category.Food, "details", "address", 6));
//		trip1.addTripItem( new Item( "Duomo", Category.Attraction, "details", "address", 6));;
//		trip1.addTripItem(new Item( "Dinner", Category.Food, "details", "address", 6));
//		// day 7 
//		trip1.addTripItem(new Item( "Flight", Category.Transportation, "flight home", "address", 7));
//		trip1.addTripItem(new Item( "Home", Category.None, "", "", 7));
//		tripRepository.save(trip1);
		
    }
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
