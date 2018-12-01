package com.example.demo.client;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bauka on 01-Dec-18
 */
@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("getClient/{id}")
    public User getClient(Long id) {
        return clientService.getClient(id);
    }
}
