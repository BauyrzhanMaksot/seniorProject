package com.example.demo.driver;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Bauka on 02-Dec-18
 */
@Entity
@Table(name = "driver_longtr_days")
public class DriverLongTRDays {
    private Long id;
    private DriverOffer driverOffer;
    private int days;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade=CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "driver_offers_id")
    public DriverOffer getDriverOffer() {
        return driverOffer;
    }

    public void setDriverOffer(DriverOffer driverOffer) {
        this.driverOffer = driverOffer;
    }

    @Column(name = "days")
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
