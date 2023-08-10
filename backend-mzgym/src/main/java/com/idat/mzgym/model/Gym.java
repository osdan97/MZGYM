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

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "GYM")
public class Gym {

    @Id
    @Column(name="gym_uuid",nullable = false,unique = true)
    private String gymUuid;
    @Column(name="description",nullable = false)
    private String description ;
    @Column(name="district",nullable = false)
    private String district;
    @Column(name="tradename",nullable = false)
    private String tradename;
    @Column(name="direction",nullable = false)
    private String direction;
    @Column(name="create_date",nullable = false)
    private LocalDateTime createdDate;
}
