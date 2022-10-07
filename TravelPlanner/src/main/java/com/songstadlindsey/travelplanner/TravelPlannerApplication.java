package com.songstadlindsey.travelplanner;

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
//    	Trip trip = tripRepository.findById((long) 18).get();    	
//    	System.out.print("Before Item");
//    	System.out.print(trip);
//    	Item item = new Item();
//    	item.setId(21);
//    	item.setCategory("Restaurant");
//    	
//    	trip.getItems().add(item);
//    	System.out.print("save trip");
//    	tripRepository.save(trip);   	
    }
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
