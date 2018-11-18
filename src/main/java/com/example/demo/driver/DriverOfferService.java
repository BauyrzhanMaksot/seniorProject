package com.example.demo.driver;

import com.example.demo.RequestDto;
import com.example.demo.client.ClientRequest;
import com.example.demo.user.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bauka on 17-Oct-18
 */
@Service
public class DriverOfferService {

    @Autowired
    private DriverOfferRepository driverOfferRepository;

    HttpStatus putOffer(RequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        DriverOffer driverOffer = new DriverOffer();
        driverOffer.setPointA(requestDto.getPointA());
        driverOffer.setPointB(requestDto.getPointB());
        driverOffer.setPrice(requestDto.getPrice());
        driverOffer.setDriver(userPrincipal.getUser());
        driverOfferRepository.save(driverOffer);
        return HttpStatus.OK;
    }

    List<DriverOffer> getOffers() {
        return driverOfferRepository.findAll();
    }

    List<DriverOffer> getMyOffers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        return driverOfferRepository.findByDriverId(userPrincipal.getUser().getId());
    }
}
