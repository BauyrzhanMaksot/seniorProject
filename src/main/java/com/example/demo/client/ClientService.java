package com.example.demo.client;

import com.example.demo.user.User;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bauka on 01-Dec-18
 */
@Service
public class ClientService {

    @Autowired
    UserRepository userRepository;

    public User getClient(Long id) {
        return userRepository.findClient(id);
    }
}
