package com.micro.hotel.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
