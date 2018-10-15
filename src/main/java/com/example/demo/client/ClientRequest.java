package com.example.demo.client;

import com.example.demo.user.User;

import javax.persistence.*;

/**
 * Created by Bauka on 15-Oct-18
 */
@Entity
@Table(name = "client_requests")
public class ClientRequest {

    private Long id;
    private String pointA;
    private String pointB;
    private String price;
    private User client;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

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

    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
