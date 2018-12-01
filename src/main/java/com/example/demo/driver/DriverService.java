package com.example.demo.driver;

import com.example.demo.user.User;
import com.example.demo.user.UserPrincipal;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bauka on 21-Oct-18
 */
@Service
public class DriverService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRegistry sessionRegistry;

    public List<User> listOnlineClient() {
        List<User> clients = new ArrayList<>();
        final List<Object> clientPrinciple = sessionRegistry.getAllPrincipals();

        for(final Object principal : clientPrinciple) {
            if(principal instanceof UserPrincipal) {
                final UserPrincipal user = (UserPrincipal) principal;
                clients.add(user.getUser());
            }
        }
        return clients;
    }

    public User getDriver(Long id) {
        return userRepository.findDriver(id);
    }
}
