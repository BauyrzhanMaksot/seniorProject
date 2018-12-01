package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bauka on 17-Oct-18
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("acceptOffer/{offerId}")
    HttpStatus acceptOffer(@PathVariable Long offerId){
        orderService.putAcceptedOffer(offerId);
        return HttpStatus.OK;
    }

    @GetMapping("acceptRequest/{requestId}")
    HttpStatus acceptRequest(@PathVariable Long requestId) {
        orderService.putAcceptedRequest(requestId);
        return HttpStatus.OK;
    }

    @GetMapping("finishOffer/{offerId}")
    HttpStatus finishOffer(@PathVariable Long offerId) {
        orderService.finishOffer(offerId);
        return HttpStatus.OK;
    }

    @GetMapping("finishRequest/{requestId}")
    HttpStatus finishRequest(@PathVariable Long requestId) {
        orderService.finishRequest(requestId);
        return HttpStatus.OK;
    }

    @GetMapping("getHistoryClient")
    List<Order> getHistoryClient() {
        return orderService.getHistoryClient();
    }

    @GetMapping("getHistoryDriver")
    List<Order> getHistoryDriver() { return orderService.getHistoryDriver(); }

    @GetMapping("getAcceptedHistoryClient")
    List<Order> getAcceptedHistoryClient() {
        return orderService.getAcceptedHistoryClient();
    }

    @GetMapping("getAcceptedHistoryDriver")
    List<Order> getAcceptedHistoryDriver() { return orderService.getAcceptedHistoryDriver(); }

}
