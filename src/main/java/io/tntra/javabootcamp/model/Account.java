package io.tntra.javabootcamp.model;

import static io.tntra.javabootcamp.enumpkg.Acc_Type.EnumtoString;
//import static io.tntra.javabootcamp.enumpkg.Acc_Type.toString;

import java.math.BigDecimal;

public class Account {
    private String OwnerName;
    private BigDecimal balance;
    private String acc_type;


   private BigDecimal minBal = new BigDecimal(0);
   private BigDecimal overDrafLimit = new BigDecimal(0);



    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = String.valueOf(EnumtoString(acc_type));
    }



    public BigDecimal getMinBal() {
        return minBal;
    }

    public void setMinBal(BigDecimal minBal) {
        this.minBal = minBal;
    }

    public BigDecimal getOverDrafLimit() {
        return overDrafLimit;
    }

    public BigDecimal setOverDrafLimit(BigDecimal overDrafLimit) {
        this.overDrafLimit = overDrafLimit;
        return overDrafLimit;
    }
}
