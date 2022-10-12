package com.songstadlindsey.travelplanner;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.songstadlindsey.travelplanner.model.Item;
import com.songstadlindsey.travelplanner.model.Trip;
import com.songstadlindsey.travelplanner.repository.ItemRepository;
import com.songstadlindsey.travelplanner.repository.TripRepository;

@SpringBootApplication
public class TravelPlannerApplication implements CommandLineRunner{

	@Autowired
    private TripRepository tripRepository;
	

	@Override
    public void run(String...args) throws Exception {
//    	Trip trip = new Trip(); 
//    	trip.setName("Test Trip add items");
//    	
//    	Item item1 = new Item();
//    	item1.setName("Lowercase");
//    	item1.setCategory("Brewery");
//    	
//    	Item item2 = new Item();
//    	item2.setName("Jules Maes");
//    	item2.setCategory("Restaurant");
//    	
//    	
//    	trip.addTripItem(item1);
//    	trip.addTripItem(item2);
//    	tripRepository.save(trip); 
		
		
    }
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
