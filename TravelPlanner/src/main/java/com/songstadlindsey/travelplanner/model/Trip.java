package com.songstadlindsey.travelplanner.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private long userId;
	
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
}
