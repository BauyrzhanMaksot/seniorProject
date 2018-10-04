package com.example.demo.user;

import com.example.demo.user.repository.UserRepository;
import com.example.demo.utils.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Bauka on 27-Sep-18
 */
@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConfirmationService userConfirmationService;

    public User register(UserDto userDto) {
        if (userDto.getLogin() == null || userDto.getPassword() == null || userDto.getEmail() == null) {
            return null;
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setEnabled(false);
        User retUser = userRepository.save(user);
        userConfirmationService.verify(user);
        return retUser;
    }

    public User getUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByLogin(login);
    }
}
