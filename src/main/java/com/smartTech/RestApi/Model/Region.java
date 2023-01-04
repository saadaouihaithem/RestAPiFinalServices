package com.smartTech.RestApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="region")
public class Region{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long  region_id;
    public String name;
    public String name_ar;
    public int services_count;

}