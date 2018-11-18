package com.example.demo.driver;

import com.example.demo.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@RestController
public class DriverOfferController {

    @Autowired
    private DriverOfferService driverOfferService;

    @PostMapping("/putOffer")
    public HttpStatus putOffer(@RequestBody RequestDto requestDto) {
        driverOfferService.putOffer(requestDto);
        return HttpStatus.OK;
    }

    @GetMapping("/getOffer")
    public List<DriverOffer> getMyOffers() {
        return driverOfferService.getMyOffers();
    }

    @GetMapping("/getOffers")
    public List<DriverOffer> getOffers(){
        return driverOfferService.getOffers();
    }
}
