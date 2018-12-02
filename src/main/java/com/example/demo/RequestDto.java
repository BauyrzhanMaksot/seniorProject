package com.example.demo;

import com.example.demo.driver.DriverLongTRDays;

import java.util.Date;
import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
public class RequestDto {

    private String pointA;
    private String pointB;
    private String price;
    private Boolean longTerm;
    private List<DriverLongTRDays> days;
    private Integer seats;
    private Date time;

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<DriverLongTRDays> getDays() {
        return days;
    }

    public void setDays(List<DriverLongTRDays> days) {
        this.days = days;
    }

    public Boolean getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(Boolean longTerm) {
        this.longTerm = longTerm;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
