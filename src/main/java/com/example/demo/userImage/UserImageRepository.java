package com.example.demo.userImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 17-Nov-18
 */
@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {
}
