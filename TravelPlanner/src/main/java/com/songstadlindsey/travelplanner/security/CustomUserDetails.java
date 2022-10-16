package com.songstadlindsey.travelplanner.security;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.songstadlindsey.travelplanner.model.Role;
import com.songstadlindsey.travelplanner.model.User;

public class CustomUserDetails implements UserDetails{
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	// get list of users roles
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
	}
	// get users full name
    public String getFullName() {
        return this.user.getFirstName() + " " + this.user.getLastName();
    }
    // get users id
    public Long getId() {
    	return this.user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }

}
