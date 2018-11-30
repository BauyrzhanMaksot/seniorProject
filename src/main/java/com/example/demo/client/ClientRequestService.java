package com.example.demo.client;

import com.example.demo.RequestDto;
import com.example.demo.user.User;
import com.example.demo.user.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@Service
public class ClientRequestService {

    @Autowired
    private ClientRequestRepository clientRequestRepository;

    @Autowired
    private SimpMessagingTemplate template;

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

    public List<ClientRequest> searchRequest(ClientRequestDao clientRequestDao) {
        return clientRequestRepository.searchRequest(clientRequestDao.getDeparture(), clientRequestDao.getArrival());
    }

    public HttpStatus deleteRequest(Long id) {
        clientRequestRepository.deleteById(id);
        return HttpStatus.OK;
    }

    public void sendNotifications() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        User user = userPrincipal.getUser();
        template.convertAndSend("/bake/driver", "New Request by " + user.getLogin());
    }
}
