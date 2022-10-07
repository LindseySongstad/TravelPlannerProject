package com.songstadlindsey.travelplanner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(name = "days")
	private Integer tripLength;
	
    @ManyToMany(cascade = {
            CascadeType.ALL
        })
	private List<Item> Items;
}
