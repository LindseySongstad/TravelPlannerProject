package com.songstadlindsey.travelplanner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.model.Trip;
import com.songstadlindsey.travelplanner.repository.TripRepository;
import com.songstadlindsey.travelplanner.serviceinter.TripServiceInterface;


@Service
public class TripService implements TripServiceInterface {
	private TripRepository tripRepository;
	
	public TripService(TripRepository tripRepository) {
		super();
		this.tripRepository = tripRepository;
	}
	
	@Override
	public Trip saveTrip(Trip trip) {
		return tripRepository.save(trip);
	}

	@Override
	public List<Trip> getAllTrips() {
		return tripRepository.findAll();
	}

	@Override
	public Trip getTripById(long id) {
		return tripRepository.findById(id).get();
	}

	@Override
	public Trip updateTrip(Trip trip) {
		return tripRepository.save(trip);
	}

	@Override
	public void deleteTrip(long id) {
		tripRepository.deleteById(id);
	}
	
	public List<Trip> findUserTrips(Long userId){
		return tripRepository.findUserTrips(userId);
	};
}
