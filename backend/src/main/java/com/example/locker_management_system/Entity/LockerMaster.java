package com.example.locker_management_system.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LockerMaster {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long lockerId;


        @Column(nullable = false)
        private long lockerNumber;

        @Column(nullable = false)
        private Lockersize lockerSize;

        @Column(nullable = false)
        private Lockerstatus lockerStatus;

        @Column(nullable = false)
        private Double lockerPrice;

        @Column(nullable = false)
        private long lockerkeyno;


}
