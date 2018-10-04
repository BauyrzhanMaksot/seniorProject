package com.example.demo;

import com.example.demo.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Bauka on 02-Oct-18
 */
@Entity
@Table(name = "verification_token")
public class VerificationToken {

    private Long id;
    private String token;
    private User user;
    private LocalDate expirationDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "expiration_date")
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public VerificationToken(String token, User user, LocalDate expirationDate) {
        this.token = token;
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public VerificationToken() {
    }
}
