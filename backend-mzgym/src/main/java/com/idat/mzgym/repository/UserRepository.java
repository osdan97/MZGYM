package com.idat.mzgym.repository;

import com.idat.mzgym.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users> findByEmail(String email);
}
