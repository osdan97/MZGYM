package com.idat.mzgym.repository;

import com.idat.mzgym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository< Gym,String> {
}
