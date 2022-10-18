package com.songstadlindsey.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songstadlindsey.travelplanner.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
