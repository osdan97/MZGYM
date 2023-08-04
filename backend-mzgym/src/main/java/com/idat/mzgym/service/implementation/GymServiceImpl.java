package com.idat.mzgym.service.implementation;

import com.idat.mzgym.dto.GymDto;
import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Memberships;
import com.idat.mzgym.repository.GymRepository;
import com.idat.mzgym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    GymRepository gymRepository;
    @Override
    public Gym createGym(GymDto gymDto) {
        Gym createGym= new Gym();
        createGym.setDescription(gymDto.getDescription());
        createGym.setDirection(gymDto.getDirection());
        createGym.setTradename(gymDto.getTradename());
        createGym.setDistrict(gymDto.getDistrict());
        createGym.setGymUuid(UUID.randomUUID().toString());
        LocalDateTime createdDate = LocalDateTime.now();
        createGym.setCreatedDate(createdDate);
        gymRepository.save(createGym);
        return createGym;
    }

    @Override
    public Gym updateGym(String id, GymDto gymDto) {
        Memberships updateMembership=new Memberships();
        if(!gymRepository.existsById(id)){

        }
        Optional<Gym> existingGym = gymRepository.findById(id);
        Gym gymUpdated = existingGym.get();
        gymUpdated.setDescription(gymDto.getDescription());
        gymUpdated.setDirection(gymDto.getDirection());
        gymUpdated.setTradename(gymUpdated.getTradename());
        gymUpdated.setDistrict(gymUpdated.getDistrict());
        gymRepository.save(gymUpdated);
        return gymUpdated;
    }

    @Override
    public List<Gym> getGyms() {
        return gymRepository.findAll();
    }

    @Override
    public void deleteGym(String id) {
        gymRepository.deleteById(id);
    }

    @Override
    public Optional<Gym> getOne(String id) {
        return gymRepository.findById(id);
    }
}
