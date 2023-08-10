package com.idat.mzgym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MEMBERSHIPS")
public class Memberships {

    @Id
    @Column(name="membership_uuid",nullable = false,unique = true)
    private String membershipUuid;
    @Column(name="name",nullable = false,unique = true)
    private String name ;
    @Column(name="price",nullable = false)
    private Double price;
    @Column(name="state")
    private String membershipState;
    @Column(name="description")
    private String description;
    @Column(name="duration",nullable = false)
    private Integer daysDuration;
}
