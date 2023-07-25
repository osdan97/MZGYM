package com.idat.mzgym.service;


import com.idat.mzgym.dto.MembershipDto;
import com.idat.mzgym.model.Memberships;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MembershipService {
    public Memberships createMembership(MembershipDto membershipDto);
    public Memberships updateMembership(String id,MembershipDto membershipDto);

    public List<Memberships> getMemberships();

    public Optional<Memberships> getOne(String id);
}
