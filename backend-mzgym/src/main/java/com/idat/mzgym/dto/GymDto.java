package com.idat.mzgym.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymDto {
    private String description ;
    private String district;
    private String tradename;
    private String direction;
}
