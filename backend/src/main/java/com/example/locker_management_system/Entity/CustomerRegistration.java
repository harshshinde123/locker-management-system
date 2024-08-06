package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class CustomerRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDate openingdate;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private long aadharNumber;
}