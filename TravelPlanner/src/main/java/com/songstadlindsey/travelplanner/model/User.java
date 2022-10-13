package com.songstadlindsey.travelplanner.model;

import java.util.ArrayList;
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
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(targetEntity = Trip.class)
	private List<Trip> trips;
	
	@ManyToMany(targetEntity = Item.class)
	private List<Item> possItems;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();
    
    public void addTrip(Trip trip) {
    	this.trips.add(trip);
    }
    public User() {
    	this.trips = new ArrayList<Trip>();
    }
}
