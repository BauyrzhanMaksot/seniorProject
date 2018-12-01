package com.example.demo.order;

import com.example.demo.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bauka on 17-Oct-18
 */
@Entity
@Table(name = "order_history")
public class Order {

    private Long id;
    private String pointA;
    private String pointB;
    private Date date;
    private String clientRating;
    private String clientComment;
    private String driverRating;
    private String driverComment;
    private User driver;
    private User client;
    private String price;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "point_a")
    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    @Column(name = "point_b")
    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "client_rating")
    public String getClientRating() {
        return clientRating;
    }

    public void setClientRating(String clientRating) {
        this.clientRating = clientRating;
    }

    @Column(name = "client_comment")
    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    @Column(name = "driver_rating")
    public String getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(String driverRating) {
        this.driverRating = driverRating;
    }

    @Column(name = "driver_comment")
    public String getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(String driverComment) {
        this.driverComment = driverComment;
    }

    @OneToOne
    @JoinColumn(name = "driver_id")
    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    @OneToOne
    @JoinColumn(name = "client_id")
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
