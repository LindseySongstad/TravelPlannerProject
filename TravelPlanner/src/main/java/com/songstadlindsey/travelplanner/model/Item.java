package com.songstadlindsey.travelplanner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.songstadlindsey.travelplanner.enums.Category;
import com.songstadlindsey.travelplanner.enums.Priority;

import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long userId;
	
	private String name;
	
	private Category category;
	
//	private String category;
	
	private String details;
	
	private String address;
	
	private Priority priority;
	
	@Column(name = "day")
	private Integer dayOfTrip;
	
	
//	@OneToOne
//	private Location location;


//  caused infinite loop when accessing, only need if bidirectional	json ignore?
//	@ManyToMany( mappedBy = "items", cascade = { CascadeType.ALL })
//	 private List<Trip> trips;
	
}

