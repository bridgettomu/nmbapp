package com.nmb.nmbApp.dto;

import com.nmb.nmbApp.model.Account;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class TransactionCreateDTO {

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private BigDecimal charge;

    private String debitAccountNumber;

    private String creditAccountNumber;
}
