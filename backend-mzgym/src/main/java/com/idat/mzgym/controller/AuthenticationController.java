package com.idat.mzgym.controller;


import com.idat.mzgym.dto.ChangePassword;
import com.idat.mzgym.dto.CustomerLoginResponse;
import com.idat.mzgym.dto.CustomerRegistration;
import com.idat.mzgym.model.Account;
import com.idat.mzgym.model.Customers;

import com.idat.mzgym.repository.AccountRepository;
import com.idat.mzgym.service.AccountService;
import com.idat.mzgym.service.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {


    @Autowired
    private AccountService accountService;

    @Autowired
    AccountRepository accountRepository;
    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody Customers customer){
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            return new ResponseEntity<>("Email can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            return new ResponseEntity<>("Password can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getName() == null || customer.getName().isEmpty()) {
            return new ResponseEntity<>("Name can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            return new ResponseEntity<>("Lastname can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findByEmail(customer.getEmail()).isPresent()) {
            return new ResponseEntity<>("This account already exists", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(accountService.createCustomer(customer), HttpStatus.CREATED);
        }
    }

    @PostMapping("/registeruuid")
    public ResponseEntity<?>registerUuid(@RequestBody Customers customer){
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            return new ResponseEntity<>("Email can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            return new ResponseEntity<>("Password can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getName() == null || customer.getName().isEmpty()) {
            return new ResponseEntity<>("Name can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            return new ResponseEntity<>("Lastname can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findByEmail(customer.getEmail()).isPresent()) {
            return new ResponseEntity<>("This account already exists", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(accountService.createCustomer2(customer), HttpStatus.CREATED);
        }
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody Account account){
        Account signInAccount = accountRepository.findByEmail(account.getEmail()).get();


        if(signInAccount==null){
            return new ResponseEntity<>("Account is not registred", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(signInAccount, HttpStatus.OK);
    }





}