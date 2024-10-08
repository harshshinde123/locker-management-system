package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class LockerIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId;

    @Column(nullable = false)
    private long accNo;


    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private LocalDate ValidDateFrom;

    @Column(nullable = false)
    private LocalDate ValidDateTo;

    @Column(nullable = false)
    private long locId;

    @OneToOne
    @JoinColumn(name = "accountNumber")
    private CustomerRegistration customerRegistration;

    @OneToOne
    @JoinColumn(name = "locker_Id")
    private LockerMaster lockerMaster;

}
