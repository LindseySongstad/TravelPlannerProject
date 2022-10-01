package com.songstadlindsey.travelplanner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String category;
	
	private priority priority;
	
	@Column(name = "day")
	private Integer dayOfTrip;
	
	@OneToOne
	private Location location;
	
}
enum priority{
	LOW,
	MEDIUM,
	HIGH
}
