package com.example.demo.street;

import javax.persistence.*;

/**
 * Created by Bauka on 04-Nov-18
 */
@Entity
@Table(name = "street")
public class Street {

    private Long id;
    private String streetName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "street_name")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
