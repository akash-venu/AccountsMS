package com.teckarch.AccountsMS.Controllers;

import com.teckarch.AccountsMS.Models.Accounts;
import com.teckarch.AccountsMS.Services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account){
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Accounts> updateAccount(@RequestBody Accounts account){
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable("id") Long accountId){
        if(accountId != null){
            return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long accountId) {
        if (accountId != null) {
            accountService.deleteAccountById(accountId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Account with ID " + accountId + " has been deleted successfully.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid account ID provided.");
        }
    }


}
