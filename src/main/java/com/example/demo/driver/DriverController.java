package com.example.demo.driver;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bauka on 21-Oct-18
 */
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("onlineClients")
    public List<User> getOnlineClients() {
        return driverService.listOnlineClient();
    }
}
