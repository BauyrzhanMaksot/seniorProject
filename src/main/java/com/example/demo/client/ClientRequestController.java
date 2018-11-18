package com.example.demo.client;

import com.example.demo.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@RestController
public class ClientRequestController {

    @Autowired
    private ClientRequestService clientRequestService;

    @PostMapping("/putRequest")
    public HttpStatus putRequest(@RequestBody RequestDto requestDto) {
        clientRequestService.putRequest(requestDto);
        clientRequestService.sendNotifications();
        return HttpStatus.OK;
    }

    @GetMapping("/getRequests")
    public List<ClientRequest> getRequest(){
        return clientRequestService.getRequests();
    }

    @PostMapping("/searchRequests")
    public List<ClientRequest> searchReqeust(@RequestBody ClientRequestDao clientRequestDao) {
        return clientRequestService.searchRequest(clientRequestDao);
    }
}
