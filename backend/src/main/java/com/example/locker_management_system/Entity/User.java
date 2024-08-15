package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Email(message = "Please enter a valid email")
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(name = "password")
    @NotBlank(message = "password id mandatory")
    private String password;

    @Column(nullable = false)
    private String role;
}
