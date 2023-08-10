package com.idat.mzgym.service;

import com.idat.mzgym.dto.GymDto;
import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Memberships;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface GymService {

    public Gym createGym(GymDto gymDto);
    public Gym updateGym(String id, GymDto gymDto);

    public List<Gym> getGyms();

    public void deleteGym(String id);

    public Optional<Gym> getOne(String id);
}
