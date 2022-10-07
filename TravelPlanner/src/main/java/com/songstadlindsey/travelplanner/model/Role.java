package com.songstadlindsey.travelplanner.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name="roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
