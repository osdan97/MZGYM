package com.idat.mzgym.security.jwt;


import com.idat.mzgym.model.Account;
import com.idat.mzgym.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(Account account);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
