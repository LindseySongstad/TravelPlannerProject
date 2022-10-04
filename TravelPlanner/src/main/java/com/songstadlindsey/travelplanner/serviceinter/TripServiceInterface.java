package com.songstadlindsey.travelplanner.serviceinter;

import java.util.List;

import com.songstadlindsey.travelplanner.model.Trip;

public interface TripServiceInterface {
	Trip saveTrip(Trip Trip);
	List<Trip> getAllTrips();
	Trip getTripById(long id);
	Trip updateTrip(Trip Trip);
	void deleteTrip(long id);
}
