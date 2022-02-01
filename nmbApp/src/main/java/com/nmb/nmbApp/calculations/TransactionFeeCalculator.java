package com.nmb.nmbApp.calculations;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionFeeCalculator {
    private BigDecimal debitAmount;
    private BigDecimal charge;

    public BigDecimal getDebitTransactionCharge(BigDecimal debitAmount){
        charge= debitAmount.multiply(BigDecimal.valueOf(0.02));

        return charge;
    }
}
