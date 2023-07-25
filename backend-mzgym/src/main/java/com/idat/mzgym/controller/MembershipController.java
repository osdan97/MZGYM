package com.idat.mzgym.controller;

import com.idat.mzgym.dto.MembershipDto;
import com.idat.mzgym.dto.Mensaje;
import com.idat.mzgym.model.Memberships;
import com.idat.mzgym.repository.MembershipRepository;
import com.idat.mzgym.service.MembershipService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/membership")
public class MembershipController {
    @Autowired
    MembershipService membershipService;

    @Autowired
    MembershipRepository membershipRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Memberships>> list() {
        List<Memberships> list = membershipService.getMemberships();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MembershipDto membershipDto) {

            membershipService.createMembership(membershipDto);
            return new ResponseEntity(new Mensaje("membership created successfully"), HttpStatus.OK);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody MembershipDto membershipDto ){
        if (!membershipRepository.existsById(id))
            return new ResponseEntity(new Mensaje(" membership does not exist"), HttpStatus.NOT_FOUND);


        Memberships membershipsUpdated = membershipService.getOne(id).get();
        membershipsUpdated.setName(membershipDto.getName());
        membershipsUpdated.setDescription(membershipDto.getDescription());
        membershipsUpdated.setPrice(membershipDto.getPrice());
        membershipsUpdated.setDaysDuration(membershipDto.getDaysDuration());

        membershipRepository.save(membershipsUpdated);
        return new ResponseEntity(new Mensaje("membership updated successfully"), HttpStatus.OK);
    }

  /*  @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if (!membershipRepository.existsById(id))
            return new ResponseEntity(new Mensaje("membership does not exist"), HttpStatus.NOT_FOUND);

        return new ResponseEntity(new Mensaje("category deleted successfully"), HttpStatus.OK);
    }*/
}
