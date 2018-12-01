package com.example.demo.order;

import com.example.demo.client.ClientRequest;
import com.example.demo.client.ClientRequestRepository;
import com.example.demo.client.ClientRequestService;
import com.example.demo.driver.DriverOffer;
import com.example.demo.driver.DriverOfferRepository;
import com.example.demo.driver.DriverOfferService;
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

    @Autowired
    private ClientRequestRepository clientRequestRepository;

    @Autowired
    private DriverOfferService driverOfferService;

    HttpStatus finishOffer(Long offerId) {
        orderRepository.finishOffer(offerId);
        return HttpStatus.OK;
    }

    HttpStatus finishRequest(Long offerId) {
        orderRepository.finishRequest(offerId);
        return HttpStatus.OK;
    }

    HttpStatus putAcceptedOffer(Long offerId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        DriverOffer driverOffer = driverOfferRepository.findById(offerId).orElse(null);
        if (driverOffer == null) return HttpStatus.NOT_FOUND;
        Order order = new Order();
        order.setDate(new Date());
        order.setPointA(driverOffer.getPointA());
        order.setPointB(driverOffer.getPointB());
        order.setClient(userPrincipal.getUser());
        order.setDriver(driverOffer.getDriver());
        order.setPrice(driverOffer.getPrice());
        order.setStatus(1);
        orderRepository.save(order);
        driverOfferService.deleteOffer(driverOffer.getId());
        return HttpStatus.OK;
    }

    HttpStatus putAcceptedRequest(Long requestId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        ClientRequest clientRequest = clientRequestRepository.findById(requestId).orElse(null);
        if (clientRequest == null) return HttpStatus.NOT_FOUND;
        Order order = new Order();
        order.setDate(new Date());
        order.setPointA(clientRequest.getPointA());
        order.setPointB(clientRequest.getPointB());
        order.setClient(clientRequest.getClient());
        order.setDriver(userPrincipal.getUser());
        order.setPrice(clientRequest.getPrice());
        order.setStatus(1);
        orderRepository.save(order);
        clientRequestService.deleteRequest(clientRequest.getId());
        return HttpStatus.OK;
    }

    List<Order> getHistoryClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Long id = userPrincipal.getUser().getId();
        return orderRepository.findHistoryByClientId(id);
    }

    List<Order> getHistoryDriver() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Long id = userPrincipal.getUser().getId();
        return orderRepository.findHistoryByDriverId(id);
    }

    List<Order> getAcceptedHistoryClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Long id = userPrincipal.getUser().getId();
        return orderRepository.findAcceptedHistoryByClientId(id);
    }

    List<Order> getAcceptedHistoryDriver() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Long id = userPrincipal.getUser().getId();
        return orderRepository.findAcceptedHistoryByDriverId(id);
    }
}
