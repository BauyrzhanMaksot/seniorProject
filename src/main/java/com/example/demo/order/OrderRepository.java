package com.example.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Bauka on 17-Oct-18
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from order_history o where o.client_id = ?1 and o.status = 1", nativeQuery = true)
    List<Order> findAcceptedHistoryByClientId(Long userId);

    @Query(value = "select * from order_history o where o.driver_id = ?1 and o.status = 1", nativeQuery = true)
    List<Order> findAcceptedHistoryByDriverId(Long userId);

    @Query(value = "select * from order_history o where o.client_id = ?1 and o.status = 2", nativeQuery = true)
    List<Order> findHistoryByClientId(Long userId);

    @Query(value = "select * from order_history o where o.driver_id = ?1 and o.status = 2", nativeQuery = true)
    List<Order> findHistoryByDriverId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "Update order_history Set status=2 where order_history.id=?1", nativeQuery = true)
    Integer finishRequest(Long id);

    @Modifying
    @Transactional
    @Query(value = "Update order_history Set status=2 where order_history.id=?1", nativeQuery = true)
    Integer finishOffer(Long id);
}
