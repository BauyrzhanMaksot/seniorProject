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

    @Autowired
    private DriverLongTRDaysRepository driverLongTRDaysRepository;

    DriverOffer getOffer(Long id) {
        return driverOfferRepository.findById(id).get();
    }

    HttpStatus updateOffer(DriverOffer driverOffer) {
        for (DriverLongTRDays d: driverOffer.getDays()
                ) {
            d.setDriverOffer(driverOffer);
            if (d.getId() == null) {
                driverLongTRDaysRepository.save(d);
            }
        }
        driverOfferRepository.save(driverOffer);
        return HttpStatus.OK;
    }

    HttpStatus putOffer(RequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        DriverOffer driverOffer = new DriverOffer();
        driverOffer.setPointA(requestDto.getPointA());
        driverOffer.setPointB(requestDto.getPointB());
        driverOffer.setPrice(requestDto.getPrice());
        driverOffer.setDriver(userPrincipal.getUser());
        driverOffer.setLongTerm(requestDto.getLongTerm());
        driverOffer.setSeats(requestDto.getSeats());
        driverOffer.setTime(requestDto.getTime());
        //driverOffer.setDays(requestDto.getDays());
        driverOffer = driverOfferRepository.save(driverOffer);
        if (requestDto.getDays() != null) {
            for (DriverLongTRDays d: requestDto.getDays()
                    ) {
                d.setDriverOffer(driverOffer);
                if (d.getId() == null) {
                    driverLongTRDaysRepository.save(d);
                }
            }
        }
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

    public HttpStatus deleteOffer(Long id) {
        driverOfferRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
