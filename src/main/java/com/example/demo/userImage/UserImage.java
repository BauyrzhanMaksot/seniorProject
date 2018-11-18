package com.example.demo.userImage;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.persistence.*;

/**
 * Created by Bauka on 17-Nov-18
 */
@Entity
@Table(name = "user_images")
public class UserImage {

    private Long id;
    private User user;
    private String location;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
