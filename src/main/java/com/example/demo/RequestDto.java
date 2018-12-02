package com.example.demo;

import com.example.demo.driver.DriverLongTRDays;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
public class RequestDto {

    private String pointA;
    private String pointB;
    private String price;
    private List<DriverLongTRDays> days;

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
}
