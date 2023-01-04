package com.smartTech.RestApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Conpany")
public class Conpany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long  id;
    public String name;
    public String name_ar;
    public String email;
    public String code;
    public int phone;
    public String cr_number;
    public String address;
    public String  lat;
    public String lng;
    public String image;
    public String website;
    public int views;
    public String description;
    public String description_ar;
    @CreationTimestamp
    @Column(name="updated_at", nullable = false, updatable = false)
    public Date updated_at;
    public String region_name;
    public String region_name_ar;
    public ArrayList<Image> images;
}