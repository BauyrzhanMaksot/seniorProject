package com.example.demo.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface DriverOfferRepository extends JpaRepository<DriverOffer, Long> {
}
