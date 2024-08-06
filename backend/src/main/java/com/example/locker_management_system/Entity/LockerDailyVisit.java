package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LockerDailyVisit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long lockerId;

        @Column(nullable = false)
        private long accountNumber;

        @Column(nullable = false)
        private LocalDate visitDate;

        @Column(nullable = false)
        private LocalTime visitTime;

        @Column(nullable = false)
        private String visitStatus;
}
