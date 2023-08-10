package com.idat.mzgym.service;


import com.idat.mzgym.dto.GymDto;
import com.idat.mzgym.dto.LocationRegisterDto;
import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    public Location createLocation(LocationRegisterDto locationRegisterDto);
    public Location updateLocations(String id, LocationRegisterDto locationRegisterDto);

    public List<Location> getLocations();

    public void deleteLocation(String id);

    public Optional<Location> getOne(String id);
}
