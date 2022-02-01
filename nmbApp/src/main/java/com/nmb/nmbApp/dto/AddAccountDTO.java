package com.nmb.nmbApp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddAccountDTO {
    private String accountNumber;
    private String currency;
    private String mobileNumber;
    private BigDecimal initialBalance;
    private BigDecimal activeBalance;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitNarration;
    private String creditNarration;
    private Long branchId;
}
