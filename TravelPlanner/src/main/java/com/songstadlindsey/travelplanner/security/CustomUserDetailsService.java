package com.songstadlindsey.travelplanner.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.songstadlindsey.travelplanner.model.User;
import com.songstadlindsey.travelplanner.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that email");
        }
         
        return new CustomUserDetails(user);
    	
    	
//        User user = userRepository.findByEmail(usernameOrEmail);
//        if(user != null){
//            return new org.springframework.security.core.userdetails.User(user.getEmail()
//                    , user.getPassword(),
//                    user.getRoles().stream()
//                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
//                            .collect(Collectors.toList()));
//        }else {
//            throw new UsernameNotFoundException("Invalid email or password");
//        }
    }
}