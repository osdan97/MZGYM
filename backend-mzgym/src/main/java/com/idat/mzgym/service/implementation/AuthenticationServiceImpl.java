package com.idat.mzgym.service.implementation;


import com.idat.mzgym.dto.CustomerLoginResponse;
import com.idat.mzgym.model.Account;
import com.idat.mzgym.security.UserPrincipal;
import com.idat.mzgym.security.jwt.JwtProvider;
import com.idat.mzgym.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public CustomerLoginResponse signInAndReturnJWT(Account signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        Account signInUser = userPrincipal.getAccount();
        signInUser.setToken(jwt);

        CustomerLoginResponse response = new CustomerLoginResponse();
        String email = signInUser.getEmail();
        response.setEmail(email);
        String token = jwt;
        response.setToken(token);
        boolean active = signInUser.isActive();
        response.setActive(active);
        return response;
    }
}
