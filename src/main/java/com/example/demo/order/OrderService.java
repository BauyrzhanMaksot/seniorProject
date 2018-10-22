package com.example.demo.order;

import com.example.demo.client.ClientRequestService;
import com.example.demo.driver.DriverOffer;
import com.example.demo.driver.DriverOfferRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserPrincipal;
import com.example.demo.user.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Bauka on 17-Oct-18
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverOfferRepository driverOfferRepository;

    @Autowired
    private ClientRequestService clientRequestService;

    HttpStatus putOrder(Long orderId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        DriverOffer driverOffer = driverOfferRepository.findById(orderId).orElse(null);
        if (driverOffer == null) return HttpStatus.NOT_FOUND;
        Order order = new Order();
        order.setDate(new Date());
        order.setPointA(driverOffer.getPointA());
        order.setPointB(driverOffer.getPointB());
        order.setClient(userPrincipal.getUser());
        order.setDriver(driverOffer.getDriver());
        orderRepository.save(order);
        clientRequestService.deleteRequest();
        return HttpStatus.OK;
    }

    List<Order> getHistoryClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Long id = userPrincipal.getUser().getId();
        return orderRepository.findByUserId(id);
    }
}
