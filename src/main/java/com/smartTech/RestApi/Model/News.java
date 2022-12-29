package com.smartTech.RestApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class News{


    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String title;
    public String description;
    public String title_ar;
    public String description_ar;
    public String category;
    public String image;
    public String status;
    public String is_feature;
    public String slug;
    public Date created_at;
    public Date updated_at;
}