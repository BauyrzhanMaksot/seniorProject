package com.example.demo.userImage;

import com.example.demo.user.User;
import com.example.demo.user.UserPrincipal;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bauka on 17-Nov-18
 */
@Service
public class UserImageService {

    @Autowired
    UserImageRepository userImageRepository;

    @Autowired
    UserRepository userRepository;

    private final Path rootLocation = Paths.get("C:/images");

    public void store(MultipartFile userImage) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
            User user = userPrincipal.getUser();
            Files.copy(userImage.getInputStream(), this.rootLocation.resolve(user.getLogin()+"_"+userImage.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    public void deleteImage(String location) throws  Exception {
        FileSystemUtils.deleteRecursively(rootLocation.resolve(location));
    }

    public void deleteUserImage(Long id) {
        userImageRepository.deleteById(id);
    }

    public Resource loadUserImage(String userImageName) {
        try {
            Path file = rootLocation.resolve(userImageName);
            Resource image = new UrlResource(file.toUri());
            if (image.exists() || image.isReadable()) {
                return image;
            } else {
                throw new RuntimeException("error");
            }
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    public void storeImageLocation(String location) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        UserImage image = new UserImage();
        image.setLocation(location);
        image.setUser(userPrincipal.getUser());
        userImageRepository.save(image);
    }

    public HttpStatus uploadUserImage(MultipartFile file) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        User user = userRepository.findByLogin(userPrincipal.getUser().getLogin());
        if (user.getUserImage() != null) {
            deleteImage(user.getUserImage().getLocation());
            deleteUserImage(user.getUserImage().getId());
        }
        store(file);
        storeImageLocation(user.getLogin()+"_"+file.getOriginalFilename());
        return HttpStatus.OK;
    }
}
