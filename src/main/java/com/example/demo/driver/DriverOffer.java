package com.example.demo.driver;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@Entity
@Table(name = "driver_offers")
public class DriverOffer {

    private Long id;
    private String pointA;
    private String pointB;
    private String price;
    private User driver;
    private List<DriverLongTRDays> days;

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
    @JoinColumn(name = "driver_id")
    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    @OneToMany(mappedBy="driverOffer")
    public List<DriverLongTRDays> getDays() {
        return days;
    }

    public void setDays(List<DriverLongTRDays> days) {
        this.days = days;
    }
}
