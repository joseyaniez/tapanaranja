package com.joseyaniez.tapanaranja.features.students.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Student
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String username;

    @CreationTimestamp
    @Column(updatable = false)
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
