package com.idat.mzgym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerUpdate {
    private String name;
    private String lastName;
    private String documentType;
    private Long documentNumber;
    private String address;

}
