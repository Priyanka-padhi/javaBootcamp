package io.tntra.javabootcamp.service;

import io.tntra.javabootcamp.exception.AccountNotAvailable;
import io.tntra.javabootcamp.exception.InSufficientBalanceException;
import io.tntra.javabootcamp.exception.MinimumBalanceException;
import io.tntra.javabootcamp.model.Account;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.math.BigDecimal;


@Service
public class HDFC_BANK extends AccountServiceImpl{
    @Override
    public BigDecimal deposit(BigDecimal amount, String ownerName) throws AccountNotAvailable {
        return super.deposit(amount, ownerName);
    }

    @Override
    public BigDecimal withdraw(String ownerName,BigDecimal amount) throws AccountNotAvailable, InSufficientBalanceException {
        return super.withdraw(ownerName,amount);
    }

    @Override
    public void createAccount(Account account) throws MinimumBalanceException {
        account.setMinBal(BigDecimal.valueOf(2000));
        if(account.getBalance().compareTo(account.getMinBal())>=0){
            super.createAccount(account);
        }
        else{
            throw new MinimumBalanceException("Minimum Balance of "+account.getMinBal()+" is require.");
        }
    }

    @Override
    public BigDecimal getAccBalance(String ownerName) throws AccountNotAvailable {
        return super.getAccBalance(ownerName);
    }

    @Override
    public void deleteAccount(String ownerName) {
        super.deleteAccount(ownerName);
    }

    @Override
    public Account getAccount(String ownerName) throws AccountNotAvailable  {
        return super.getAccount(ownerName);
    }
    public HashMap<String, Account> getAllAccount() {

        return super.getAllAccount();
    }
}
