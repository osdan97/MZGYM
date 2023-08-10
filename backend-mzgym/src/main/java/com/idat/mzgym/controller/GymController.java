package com.idat.mzgym.controller;

import com.idat.mzgym.dto.GymDto;
import com.idat.mzgym.dto.MembershipDto;
import com.idat.mzgym.dto.Mensaje;
import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Memberships;
import com.idat.mzgym.repository.GymRepository;
import com.idat.mzgym.service.GymService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gym")
public class GymController {
    @Autowired
    GymService gymService;

    @Autowired
    GymRepository gymRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Gym>> list() {
        List<Gym> list = gymService.getGyms();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GymDto gymDto) {
            gymService.createGym(gymDto);
            return new ResponseEntity(new Mensaje("gym created successfully"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody GymDto gymDto) {
        if (!gymRepository.existsById(id))
            return new ResponseEntity(new Mensaje(" gym does not exist"), HttpStatus.NOT_FOUND);


        Gym gym = gymService.getOne(id).get();
        gym.setTradename(gymDto.getTradename());
        gym.setDescription(gymDto.getDescription());
        gym.setDistrict(gymDto.getDistrict());
        gym.setDirection(gymDto.getDirection());
        gymRepository.save(gym);
        return new ResponseEntity(new Mensaje("gym updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if (!gymRepository.existsById(id))
            return new ResponseEntity(new Mensaje("gym does not exist"), HttpStatus.NOT_FOUND);
        gymService.deleteGym(id);
        return new ResponseEntity(new Mensaje("gym deleted successfully"), HttpStatus.OK);
    }
}
