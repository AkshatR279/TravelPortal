package com.akshatr.travelportal.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tbl_User")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    private String username;
    private String password;
    private String name;
    private String mobile;
    private String email;

    @CreationTimestamp
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp modifyDate;

    private Boolean active;
}
