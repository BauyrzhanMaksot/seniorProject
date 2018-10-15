package com.example.demo.client;

import com.example.demo.RequestDto;
import com.example.demo.user.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@Service
public class ClientRequestService {

    @Autowired
    private ClientRequestRepository clientRequestRepository;

    public HttpStatus putRequest(RequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setPointA(requestDto.getPointA());
        clientRequest.setPointB(requestDto.getPointB());
        clientRequest.setPrice(requestDto.getPrice());
        clientRequest.setClient(userPrincipal.getUser());
        clientRequestRepository.save(clientRequest);
        return HttpStatus.OK;
    }

    public List<ClientRequest> getRequests(){
        return clientRequestRepository.findAll();
    }
}
