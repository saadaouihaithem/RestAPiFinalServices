package com.smartTech.RestApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import lombok.Builder;
import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import lombok.Builder;
import javax.persistence.*;


@Entity
@Table(name = "Image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @Column(name = "Image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Image_id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "image", unique = false, nullable = false, length = 1000)
    private byte[] image;

}