package com.example.demo.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface DriverOfferRepository extends JpaRepository<DriverOffer, Long> {

    List<DriverOffer> findByDriverId(Long id);
}
