package com.project.flightreservation.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class User extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
