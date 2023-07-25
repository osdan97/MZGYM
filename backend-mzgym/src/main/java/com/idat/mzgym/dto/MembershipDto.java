package com.idat.mzgym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDto {
     private String name;
     private Integer daysDuration;
     private Double price;
     private String description;

}
