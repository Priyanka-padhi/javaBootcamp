package io.tntra.javabootcamp.service;
import java.math.BigDecimal;
import java.util.HashMap;
import io.tntra.javabootcamp.enumpkg.Acc_Type;
import io.tntra.javabootcamp.exception.*;
import io.tntra.javabootcamp.model.Account;
import org.springframework.stereotype.Component;

@Component
public class  AccountServiceImpl implements AccountService {
    private final HashMap<String, Account> accObj = new HashMap<>();
    @Override
    public BigDecimal deposit( BigDecimal amount, String ownerName) throws AccountNotAvailable{

        if(checkAccount(ownerName)){
            BigDecimal   currentBal =  getAccBalance(ownerName);
            BigDecimal newBal = currentBal.add(amount);
            accObj.get(ownerName).setBalance(newBal);
            return newBal;
        }else {
            throw new AccountNotAvailable("This Account  Does not Exist.");
        }
    }

    @Override
    public BigDecimal withdraw(String ownerName, BigDecimal amount) throws AccountNotAvailable,InSufficientBalanceException{

        if(checkAccount(ownerName)){
            if (checkBalance(ownerName,amount)) {
                BigDecimal currentBalance = getAccBalance(ownerName);
                BigDecimal balance = currentBalance.subtract(amount);
                accObj.get(ownerName).setBalance(balance);
                return balance;
            }
            throw new InSufficientBalanceException("Insufficient Balance in your Account!!");
        }
        throw new AccountNotAvailable("This Account does not exist");
    }


    @Override
    public void createAccount(Account account) throws MinimumBalanceException {

        accObj.put(account.getOwnerName(), account);
    }

    @Override
    public BigDecimal getAccBalance(String ownerName) throws AccountNotAvailable{
       return accObj.get(ownerName).getBalance();}



    @Override
    public void deleteAccount(String ownerName) {
        accObj.remove(ownerName);
    }

    @Override
    public HashMap<String, Account> getAllAccount() {

        return accObj;
    }
    public Account getAccount(String ownerName) throws AccountNotAvailable{
        if(checkAccount(ownerName)){
            return accObj.get(ownerName);
        }
        else{
            throw new AccountNotAvailable("This Account Does not Exist");
        }
}
public  boolean checkBalance(String ownerName,BigDecimal amount) throws AccountNotAvailable{
    BigDecimal currentBalance = getAccBalance(ownerName);

    if (checkAccount(ownerName) && accObj.get(ownerName).getAcc_type() == "CURRENTACCOUNT") {
        BigDecimal overDraftLimit = accObj.get(ownerName).setOverDrafLimit(BigDecimal.valueOf(0.2));
        BigDecimal newOverDraft = overDraftLimit.multiply(accObj.get(ownerName).getBalance());

        BigDecimal newBalance = currentBalance.add(newOverDraft);
        return newBalance.compareTo(amount) >= 0;
    }
    return currentBalance.compareTo(amount)>=0;
}


    public boolean checkAccount(String ownerName) {
        return accObj.containsKey(ownerName);
    }
}
