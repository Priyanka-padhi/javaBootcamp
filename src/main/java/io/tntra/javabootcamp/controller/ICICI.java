package io.tntra.javabootcamp.controller;

import io.tntra.javabootcamp.exception.MinimumBalanceException;
import io.tntra.javabootcamp.model.Account;
import io.tntra.javabootcamp.service.ICICI_BANK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class ICICI {
   final
   ICICI_BANK icici;

    public ICICI(ICICI_BANK icici) {
        this.icici = icici;
    }


    @RequestMapping(value = "icici", method = RequestMethod.POST)
    public ResponseEntity<Object> createAccount(@RequestBody  Account account) {
        try{
            icici.createAccount(account);
            return new ResponseEntity<>("Account is created Successfully in ICICI BANK.", HttpStatus.CREATED);

        }
        catch(MinimumBalanceException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Minimum Balance of 3000 is require.", HttpStatus.NOT_ACCEPTABLE);

        }
    }
    @RequestMapping(value = "icici/{ownerName}",method= RequestMethod.GET)
    public ResponseEntity<Object> getAccount(@PathVariable("ownerName")String ownerName) {
        try{
            return new ResponseEntity<>(icici.getAccount(ownerName),HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Account Does not Exist", HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "icici", method= RequestMethod.GET)
    public ResponseEntity<Object> getAllAccount() {
        return new ResponseEntity<>(icici.getAllAccount(), HttpStatus.OK);
    }

    @RequestMapping(value = "icici/getBal/{ownerName}",method= RequestMethod.GET)
    public ResponseEntity<Object> getAccBalance(@PathVariable("ownerName")String ownerName) {
        try{
            return new ResponseEntity<>("Account Balance of "+ownerName+ "= "+icici.getAccBalance(ownerName),HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Account Does not Exist", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "icici/deposit/{ownerName}/{amount}", method = RequestMethod.PATCH)
    public ResponseEntity<Object>
    deposit(@PathVariable("ownerName") String ownerName, @PathVariable ("amount") BigDecimal amount) {
        try{
            icici.deposit(amount,ownerName);
            return new ResponseEntity<>("Amount Deposited Successfully!!", HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Invalid Account", HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "icici/withdraw/{ownerName}/{amount}", method = RequestMethod.PATCH)
    public ResponseEntity<Object>
    withdraw(@PathVariable("ownerName") String ownerName, @PathVariable ("amount") BigDecimal amount) {
        try{
            icici.withdraw(ownerName,amount);
            return new ResponseEntity<>("Amount Withdraw Successfully!!", HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Invalid Account", HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(value = "icici/delete/{ownerName}",method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAccount(@PathVariable("ownerName")String ownerName) {
        try{
            return new ResponseEntity<>(ownerName+ "'s account is closed Successfully.",HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Account Does not Exist", HttpStatus.BAD_REQUEST);
        }
    }
}
