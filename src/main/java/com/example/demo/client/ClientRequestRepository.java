package com.example.demo.client;

import com.example.demo.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {

    @Query(value = "select * from client_requests o where o.point_a like ?1% and o.point_b like ?2%", nativeQuery = true)
    List<ClientRequest> searchRequest(String departure, String arrival);
}
