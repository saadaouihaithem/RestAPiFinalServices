package com.smartTech.RestApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int category_id ;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    @JsonIgnore
    private List<Services> services;

}