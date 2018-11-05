package com.example.demo.street;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 04-Nov-18
 */
@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

}
