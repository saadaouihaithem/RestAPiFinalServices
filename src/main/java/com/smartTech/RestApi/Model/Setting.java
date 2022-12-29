package com.smartTech.RestApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Setting")
public class Setting{

    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String name;
    public String value;
}
