package com.idat.mzgym.service.implementation;

import com.idat.mzgym.dto.MembershipDto;
import com.idat.mzgym.model.Memberships;
import com.idat.mzgym.repository.MembershipRepository;
import com.idat.mzgym.service.MembershipService;
import com.idat.mzgym.util.enums.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepository;
    @Override
    public Memberships createMembership(MembershipDto membershipDto) {
        Memberships saveMembership=new Memberships();
        String membership_uuid= UUID.randomUUID().toString();
        saveMembership.setMembershipUuid(membership_uuid);
        String name=membershipDto.getName();
        saveMembership.setName(name);
        String description=membershipDto.getDescription();
        saveMembership.setDescription(description);
        Double price=membershipDto.getPrice();
        saveMembership.setPrice(price);
        Integer days=membershipDto.getDaysDuration();
        saveMembership.setDaysDuration(days);
        saveMembership.setMembershipState(Membership.INACTIVE.toString());

        membershipRepository.save(saveMembership);
        return saveMembership;
    }

    @Override
    public Memberships updateMembership(String id,MembershipDto membershipDto) {
        Memberships updateMembership=new Memberships();
        if(!membershipRepository.existsById(id)){
            throw new IllegalStateException("Membership does not exists");
        }
        Optional<Memberships> existingMembership = membershipRepository.findById(id);
        Memberships membershipUpdated = existingMembership.get();
        membershipUpdated.setName(membershipDto.getName());
        membershipUpdated.setDescription(membershipDto.getDescription());
        membershipUpdated.setPrice(membershipDto.getPrice());
        membershipUpdated.setDaysDuration(membershipDto.getDaysDuration());

        membershipRepository.save(membershipUpdated);


        return membershipUpdated;
    }

    @Override
    public List<Memberships> getMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public Optional<Memberships> getOne(String id) {

           return membershipRepository.findById(id);

    }
}
