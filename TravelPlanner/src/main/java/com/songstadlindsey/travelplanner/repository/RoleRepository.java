package com.songstadlindsey.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songstadlindsey.travelplanner.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
