package com.example.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bauka on 17-Oct-18
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from order_history o where o.client_id = ?1", nativeQuery = true)
    List<Order> findByUserId(Long userId);
}
