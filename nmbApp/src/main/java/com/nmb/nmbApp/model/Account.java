package com.nmb.nmbApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    private String currency;
    private String mobileNumber;
    private BigDecimal initialBalance;
    private BigDecimal activeBalance;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitNarration;
    private String creditNarration;

    @CreationTimestamp
    private LocalDate dateCreated;

    @UpdateTimestamp
    private LocalDate dateUpdated;

    @OneToOne(fetch = FetchType.LAZY)
    private Branch branch;


}
