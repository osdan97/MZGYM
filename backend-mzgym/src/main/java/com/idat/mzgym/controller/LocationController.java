package com.idat.mzgym.controller;

import com.idat.mzgym.dto.GymDto;
import com.idat.mzgym.dto.LocationRegisterDto;
import com.idat.mzgym.dto.Mensaje;
import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Location;
import com.idat.mzgym.repository.LocationRepository;
import com.idat.mzgym.service.LocationService;
import com.idat.mzgym.service.implementation.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    LocationService locationService;

    @GetMapping("/list")
    public ResponseEntity<List<Location>> list() {
        List<Location> list = locationService.getLocations();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LocationRegisterDto locationRegisterDto) {
        locationService.createLocation(locationRegisterDto);
        return new ResponseEntity(new Mensaje("location created successfully"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody LocationRegisterDto locationRegisterDto) {
        if (!locationRepository.existsById(id))
            return new ResponseEntity(new Mensaje(" location does not exist"), HttpStatus.NOT_FOUND);


        Location locationUpdated = locationService.getOne(id).get();
        locationUpdated.setName(locationRegisterDto.getName());
        locationUpdated.setCity(locationRegisterDto.getCity());
        locationUpdated.setCapacity(locationRegisterDto.getCapacity());
        locationUpdated.setDistrict(locationRegisterDto.getDistrict());
        locationUpdated.setDirection(locationRegisterDto.getDirection());
        locationUpdated.setEquipamentDetail(locationRegisterDto.getEquipamentDetail());
        locationRepository.save(locationUpdated);
        return new ResponseEntity(new Mensaje("location updated successfully"), HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<?>findById(@PathVariable("id") String id){
        if (!locationRepository.existsById(id))
            return new ResponseEntity(new Mensaje("location does not exist"), HttpStatus.NOT_FOUND);
        Location locationFound = locationService.getOne(id).get();
        return new ResponseEntity(locationFound,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if (!locationRepository.existsById(id))
            return new ResponseEntity(new Mensaje("location does not exist"), HttpStatus.NOT_FOUND);
        locationService.deleteLocation(id);
        return new ResponseEntity(new Mensaje("location deleted successfully"), HttpStatus.OK);
    }
}
