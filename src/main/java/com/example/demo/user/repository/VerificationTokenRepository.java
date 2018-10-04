package com.example.demo.user.repository;

import com.example.demo.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 02-Oct-18
 */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>  {

    VerificationToken findByToken(String token);
}
