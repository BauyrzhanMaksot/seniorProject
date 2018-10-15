package com.example.demo.client;

import com.example.demo.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {
}
