package com.idat.mzgym.repository;

import com.idat.mzgym.model.Gym;
import com.idat.mzgym.model.Memberships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Memberships,String> {
}
