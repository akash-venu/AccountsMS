package com.teckarch.AccountsMS.Services;

import com.teckarch.AccountsMS.Models.Accounts;
import com.teckarch.AccountsMS.Repository.AccountsRepository;
import com.teckarch.AccountsMS.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<Accounts> getAllAccounts(){
        return accountsRepository.findAll();
    }

    @Override
    public Accounts getAccountById(Long accountId) {
        return accountsRepository.findById(accountId).orElse(null);
    }

    @Override
    public Accounts addAccount(Accounts accounts) {
        return accountsRepository.save(accounts);
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountsRepository.deleteById(accountId);
    }

    @Override
    public Accounts updateAccount(Accounts accounts) {
        return accountsRepository.save(accounts);
    }


}
