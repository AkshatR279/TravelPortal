package com.akshatr.travelportal.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_Login_Details")
@Getter
@Setter
public class LoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private Timestamp loginDate;

    private Timestamp logoutDate;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean loggedIn;

    private String token;
    private Timestamp expiryTime;
}
