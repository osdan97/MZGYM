package com.idat.mzgym.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @Column(name="location_uuid",nullable = false,unique = true)
    private String locationUuid;
    @Column(name="name",nullable = false)
    private String name ;
    @Column(name="district",nullable = false)
    private String district;
    @Column(name="city",nullable = false)
    private String city;
    @Column(name="direction",nullable = false)
    private String direction;
    @Column(name="capacity",nullable = false)
    private String capacity;
    @Column(name="equipament_detail",nullable = false)
    private String equipamentDetail;

    public Location(String name,String district,String city,String direction,String capacity,String equipamentDetail ){
        this.locationUuid= UUID.randomUUID().toString();
        this.name=name;
        this.district=district;
        this.city=city;
        this.direction=direction;
        this.capacity=capacity;
        this.equipamentDetail=equipamentDetail;
    }

}
