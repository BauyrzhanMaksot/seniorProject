package com.example.demo.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 22-Nov-18
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
