package com.example.demo.user.repository;

import com.example.demo.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
