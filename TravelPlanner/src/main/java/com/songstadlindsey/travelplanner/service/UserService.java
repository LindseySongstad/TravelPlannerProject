package com.songstadlindsey.travelplanner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.model.User;
import com.songstadlindsey.travelplanner.repository.UserRepository;
import com.songstadlindsey.travelplanner.serviceinter.UserServiceInterface;


@Service
public class UserService implements UserServiceInterface {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}

	// not finished
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
