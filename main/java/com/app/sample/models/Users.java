package com.app.sample.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Where(clause="status='Active'")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fName")
    private String fName;

    @Column(name = "lName")
    private String lName;

    @Column(name = "email")
    private String email;

    @Column(name = "pinCode")
    private Integer pinCode;

    @Column(name = "birthDate", nullable = false, updatable = false)
    private Instant birthDate;

    @JsonIgnore
    @Column(name = "status")
    private String status;
}
