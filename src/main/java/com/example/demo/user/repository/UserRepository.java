package com.example.demo.user.repository;

import com.example.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 27-Sep-18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String s);

    @Query(value = "select * from user  where user.id = ?1 and user.role_id = 3", nativeQuery = true)
    User findDriver(Long id);

    @Query(value = "select * from user  where user.id = ?1 and user.role_id = 2", nativeQuery = true)
    User findClient(Long id);
}
