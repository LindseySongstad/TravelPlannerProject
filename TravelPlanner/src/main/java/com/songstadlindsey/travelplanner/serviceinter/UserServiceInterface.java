package com.songstadlindsey.travelplanner.serviceinter;

import java.util.List;

import com.songstadlindsey.travelplanner.dto.UserDto;
import com.songstadlindsey.travelplanner.entity.User;

public interface UserServiceInterface {
//	User saveUser(User User);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User User);
	void deleteUser(long id);
	
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
