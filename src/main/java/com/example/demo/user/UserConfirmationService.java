package com.example.demo.user;

import com.example.demo.VerificationToken;
import com.example.demo.user.repository.VerificationTokenRepository;
import com.example.demo.utils.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Bauka on 02-Oct-18
 */
@Service
public class UserConfirmationService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private MailSenderService mailSenderService;

    public void verify(User user) {
        LocalDate expDate = LocalDate.now().plusDays(1);
        String token = UUID.randomUUID().toString();
        VerificationToken tokenObj = new VerificationToken(token,user,expDate);
        verificationTokenRepository.save(tokenObj);
        try {
            mailSenderService.generateAndSendEmail(user.getEmail(), "localhost:8080/bake/"+token);
        } catch (Exception e) {

        }
    }

    public void confirm(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken != null && verificationToken.getUser() != null) {
            verificationToken.getUser().setEnabled(true);
            verificationTokenRepository.save(verificationToken);
            verificationTokenRepository.delete(verificationToken);
        }
    }
}
