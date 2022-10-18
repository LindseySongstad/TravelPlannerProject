package com.songstadlindsey.travelplanner.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private long userId;
	
	private String description;
	
	@Column(name = "days")
	private Integer tripLength;
	
    @ManyToMany( cascade = {CascadeType.ALL})
    @JoinTable(
            name = "trip_item",
            joinColumns = {
                @JoinColumn(name = "trip_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "item_id")
            }
        )
	private List<Item> items;
    
    public void addTripItem(Item item) {
    	this.items.add(item);
    }
    public Trip() {
    	this.items = new ArrayList<Item>();
    }
    
    public Trip(String name, String description, int length) {
    	this.name = name;
    	this.description = description;
    	this.tripLength = length;
    	this.items = new ArrayList<Item>();
    }
	public Trip(long id, String name, long userId, String description, Integer tripLength) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.description = description;
		this.tripLength = tripLength;
	}
    
    
}
