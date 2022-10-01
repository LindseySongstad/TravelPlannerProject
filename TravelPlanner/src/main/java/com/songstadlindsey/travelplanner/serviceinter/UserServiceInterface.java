package com.songstadlindsey.travelplanner.serviceinter;

import java.util.List;

import com.songstadlindsey.travelplanner.model.User;

public interface UserServiceInterface {
	User saveUser(User User);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User User);
	void deleteUser(long id);
}
