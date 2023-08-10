package com.idat.mzgym.service;


import com.idat.mzgym.dto.CustomerLoginResponse;
import com.idat.mzgym.model.Account;

public interface AuthenticationService {
    CustomerLoginResponse signInAndReturnJWT(Account signInRequest);
}
