package com.example.demo.driver;

import com.example.demo.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/getOffer/{id}")
    public DriverOffer getOffer(@PathVariable Long id) {
     return driverOfferService.getOffer(id);
    }

    @PostMapping("/updateOffer")
    public HttpStatus updateOffer(@RequestBody DriverOffer driverOffer) {
        return driverOfferService.updateOffer(driverOffer);
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
