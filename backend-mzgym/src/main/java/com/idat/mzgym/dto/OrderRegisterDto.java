package com.idat.mzgym.dto;

import com.idat.mzgym.model.Account;
import com.idat.mzgym.model.Location;
import com.idat.mzgym.model.Memberships;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegisterDto {
    private Account account;
    private Memberships membership;
    private Location location;
    private String description;
}
