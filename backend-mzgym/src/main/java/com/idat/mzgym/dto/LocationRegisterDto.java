package com.idat.mzgym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRegisterDto {

    private String name ;
    private String district;
    private String city;
    private String direction;
    private String capacity;
    private String equipamentDetail;
}
