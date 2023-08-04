package com.idat.mzgym.service.implementation;

import com.idat.mzgym.dto.LocationRegisterDto;
import com.idat.mzgym.model.Location;
import com.idat.mzgym.repository.LocationRepository;
import com.idat.mzgym.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Override
    public Location createLocation(LocationRegisterDto locationRegisterDto) {
        Location saveLocation =new Location(
                locationRegisterDto.getName(),
                locationRegisterDto.getDistrict(),
                locationRegisterDto.getCity(),
                locationRegisterDto.getDirection(),
                locationRegisterDto.getCapacity(),
                locationRegisterDto.getEquipamentDetail()
        );
        locationRepository.save(saveLocation);
        return saveLocation;
    }

    @Override
    public Location updateLocations(String id, LocationRegisterDto locationRegisterDto) {
        if(!locationRepository.existsById(id)){
            throw new IllegalStateException("location does not exists");
        }
        Location updateLocation= locationRepository.findById(id).get();
        updateLocation.setName(locationRegisterDto.getName());
        updateLocation.setCity(locationRegisterDto.getCity());
        updateLocation.setCapacity(locationRegisterDto.getCapacity());
        updateLocation.setDistrict(locationRegisterDto.getDistrict());
        updateLocation.setDirection(locationRegisterDto.getDirection());
        updateLocation.setEquipamentDetail(locationRegisterDto.getEquipamentDetail());

        locationRepository.save(updateLocation);
        return updateLocation;
    }

    @Override
    public List<Location> getLocations() {

        return locationRepository.findAll();
    }

    @Override
    public void deleteLocation(String id) {
        if(!locationRepository.existsById(id)) {
            throw new IllegalStateException("location does not exists");
        }
        locationRepository.deleteById(id);
    }

    @Override
    public Optional<Location> getOne(String id) {
        return locationRepository.findById(id);
    }
}
