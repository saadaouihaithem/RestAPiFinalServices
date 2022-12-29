package com.smartTech.RestApi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="services")
public class Services{

@Id

  @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="title_ar")
    private String title_ar;
   @Column(length = 65555)
   @NotNull
    private String description;
     @Column(length = 65555)
    @NotNull
    private String description_ar;
    @Column(name="region_id")
    private String region_id;
    @Column(name="price")
    private int price;
    @Column(name="category_id")
    private int category_id;
    @Column(name="user_id")
    private int user_id;
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="promoted")
    private Promoted promoted;
    @Column(name="paid_amount")
    private Integer paid_amount;
    @Column(name="expiry_date")
    private Date expiry_date;
    @Column(name="status")
    private Status status;
    @Column(name="slug")
    private String slug;
    @Column(name="views")
    private int views;
    @Column(name="address")
    private String address;
    @Column(name="lat")
    private String lat;
    @Column(name="lng")
    private String lng;
    @Column(name="reference_id")
    private String reference_id;
    @CreationTimestamp
    @Column(name="updated_at", nullable = false, updatable = false)
    private LocalDateTime updated_at;
    @UpdateTimestamp
    @Column(name="created_at")
    private LocalDateTime created_at;
    public ArrayList<Image> images;
    private double rating=0;
    public void setAvgRating() {
    if (reviews!=null)
    this.rating=reviews.stream().map(Reviews::getStars).reduce(0.0,Double::sum)/reviews.size();
    }
  @JsonIgnore
    private String serviceStatus= Status.PENDING.getServiceStatus();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    @JsonIgnore
    private List<Reviews> reviews;
    @ManyToOne(targetEntity = ServiceCategory.class)
    private ServiceCategory serviceCategory;
   }
