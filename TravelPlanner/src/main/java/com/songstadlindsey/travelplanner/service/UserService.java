package com.songstadlindsey.travelplanner.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.dto.UserDto;
import com.songstadlindsey.travelplanner.model.Role;
import com.songstadlindsey.travelplanner.model.User;
import com.songstadlindsey.travelplanner.repository.RoleRepository;
import com.songstadlindsey.travelplanner.repository.UserRepository;
import com.songstadlindsey.travelplanner.serviceinter.UserServiceInterface;


@Service
public class UserService implements UserServiceInterface {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
	
    public UserService(UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.passwordEncoder = passwordEncoder;
    }
	
//	@Override
//	public void saveUser(User user) {
//		return userRepository.save(user);	
//	}
	
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        //user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
