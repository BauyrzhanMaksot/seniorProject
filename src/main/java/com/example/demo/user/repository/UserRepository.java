package com.example.demo.user.repository;

import com.example.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 27-Sep-18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String s);
}
