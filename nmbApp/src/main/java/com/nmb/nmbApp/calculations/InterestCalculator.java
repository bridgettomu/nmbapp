package com.nmb.nmbApp.calculations;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InterestCalculator {
    private BigDecimal initialBalance;
    private BigDecimal activeBalance;
    private BigDecimal creditAmount;

    public BigDecimal getBiweeklyInterest(BigDecimal creditAmount,BigDecimal initialBalance){
        if(creditAmount != null)
        activeBalance =  initialBalance.multiply(BigDecimal.valueOf(0.03));
        return activeBalance;
    }

    public BigDecimal getMonthlyInterest(BigDecimal creditAmount,BigDecimal initialBalance){
        if(creditAmount != null)
          activeBalance =  initialBalance.multiply(BigDecimal.valueOf(0.06));
        return activeBalance;
    }

}
