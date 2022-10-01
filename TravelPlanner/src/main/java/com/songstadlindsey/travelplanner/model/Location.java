package com.songstadlindsey.travelplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="location")

public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long lat;
	
	private long lng;
	
	private String address;
}
