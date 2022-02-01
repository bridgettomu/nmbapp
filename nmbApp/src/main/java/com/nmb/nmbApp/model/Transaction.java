package com.nmb.nmbApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private BigDecimal charge;


    @ManyToOne
    Account debitAccount;

    @ManyToOne
    Account creditAccount;


}
