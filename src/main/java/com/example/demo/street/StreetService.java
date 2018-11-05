package com.example.demo.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bauka on 04-Nov-18
 */
@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    List<Street> getStreets() {
        return streetRepository.findAll();
    }
}
