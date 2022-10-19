package com.songstadlindsey.travelplanner.entity;

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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

	public Item(Long userId, String name, Category category, String details, String address, Integer dayOfTrip) {
		super();
		this.userId = userId;
		this.name = name;
		this.category = category;
		this.details = details;
		this.address = address;
		this.dayOfTrip = dayOfTrip;
	}
	
	
//	@OneToOne
//	private Location location;


//  caused infinite loop when accessing, only need if bidirectional	json ignore?
//	@ManyToMany( mappedBy = "items", cascade = { CascadeType.ALL })
//	 private List<Trip> trips;
	
}

