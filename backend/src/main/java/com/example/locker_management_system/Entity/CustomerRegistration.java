package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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
    @Email(message = "please enter valid email")
    private String email;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{10}", message = "phone number number must be a 12-digit number")
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDate openingdate;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{12}", message = "Aadhar number must be a 12-digit number")
    private String aadharNumber;
}