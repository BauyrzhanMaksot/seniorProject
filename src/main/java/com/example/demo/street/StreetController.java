package com.example.demo.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bauka on 04-Nov-18
 */
@RestController
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping("getStreets")
    public List<Street> getStreets(){
        return streetService.getStreets();
    }
}
