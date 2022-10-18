package com.songstadlindsey.travelplanner.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name="roles")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
