package com.example.demo.userImage;

import com.example.demo.user.CustomUserDetailsService;
import com.example.demo.user.User;
import com.example.demo.user.UserPrincipal;
import com.example.demo.user.repository.UserRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bauka on 17-Nov-18
 */
@RestController
public class UserImageController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    UserImageService userImageService;

    @PostMapping("/uploadUserImage")
    public HttpStatus uploadUserImage(@RequestParam("file") MultipartFile file) {
        try {
            return userImageService.uploadUserImage(file);
        } catch (Exception e) {
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

    @GetMapping("/bake/images/{image:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String image) {
        Resource file = userImageService.loadUserImage(image);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
