package io.tntra.javabootcamp.service;
import io.tntra.javabootcamp.model.Account;
import io.tntra.javabootcamp.exception.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface AccountService {


    public  void createAccount(Account account) throws MinimumBalanceException;
   // public  Collection<Account> getAccounts();
    HashMap<String,Account> getAllAccount();
    Account getAccount(String ownerName) throws AccountNotAvailable;
    public  BigDecimal getAccBalance(String ownerName) throws AccountNotAvailable;
  //  public  BigDecimal deposit(BigDecimal amount, String ownerName);

   public BigDecimal deposit(BigDecimal amount, String ownerName) throws AccountNotAvailable;

    public BigDecimal withdraw(String ownerName,BigDecimal amount) throws AccountNotAvailable,InSufficientBalanceException;
    public boolean checkAccount(String ownerName);
    public boolean checkBalance(String ownerName,BigDecimal amount) throws AccountNotAvailable;

    public  void deleteAccount(String ownerName);

}