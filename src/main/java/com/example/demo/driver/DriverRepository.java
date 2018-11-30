package com.example.demo.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 22-Nov-18
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
