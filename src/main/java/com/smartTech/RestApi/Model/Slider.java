package com.smartTech.RestApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Slider")
public class Slider{


    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String type;
    public String image;
    public String banner;
    public int reference_id;
    public String slug;
}