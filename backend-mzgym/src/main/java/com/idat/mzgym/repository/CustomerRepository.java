package com.idat.mzgym.repository;


import com.idat.mzgym.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerRepository extends JpaRepository<Customers, String> {
    Optional<Customers> findByEmail(String email);

    Optional<Customers> findByAccountUuid(String uuid);
}
