package com.example.demo.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 02-Dec-18
 */
@Repository
public interface DriverLongTRDaysRepository extends JpaRepository<DriverLongTRDays, Long> {

}
