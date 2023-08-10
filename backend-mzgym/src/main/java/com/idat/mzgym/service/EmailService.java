package com.idat.mzgym.service;


import com.idat.mzgym.dto.EmailValues;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface EmailService {
    void sendEmailForgotPassword(EmailValues emailValues) throws MessagingException, UnsupportedEncodingException;

    void sendEmailVerificationCode(EmailValues emailValues) throws MessagingException, UnsupportedEncodingException;

}