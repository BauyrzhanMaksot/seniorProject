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
        orderService.putOrder(offerId);
        return HttpStatus.OK;
    }

    @GetMapping("getHistory")
    List<Order> getHistoryClient() {
        return orderService.getHistoryClient();
    }
}
