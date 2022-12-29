package com.smartTech.RestApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Page{
    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String title;
    public String title_ar;
    public String description;
    public String description_ar;
}