package com.songstadlindsey.travelplanner.model;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "fname", nullable = false)
	private String firstName;
	
	@Column(name = "lname", nullable = false)
	private String lastName;	
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany(targetEntity = Trip.class)
	private List<Trip> trips;
}
