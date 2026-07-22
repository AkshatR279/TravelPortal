package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.LoginDetails;
import com.akshatr.travelportal.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {
    @Query(value = "SELECT ld " +
            "FROM LoginDetails ld " +
            "WHERE ld.user = :user " +
            "AND ld.loggedIn = true " +
            "ORDER BY ld.id DESC " +
            "LIMIT 1")
    public Optional<LoginDetails> findActiveLoginByUser(@Param("user") User user);
}
