package com.venkatesh.enterpriselevelpractice.repository;

import com.venkatesh.enterpriselevelpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByGmail(String email);
}