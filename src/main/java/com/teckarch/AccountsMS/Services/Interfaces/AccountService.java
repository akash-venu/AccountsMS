package com.teckarch.AccountsMS.Services.Interfaces;

import com.teckarch.AccountsMS.Models.Accounts;

import java.util.List;

public interface AccountService {
    List<Accounts> getAllAccounts();
    Accounts getAccountById(Long accountId);
    Accounts addAccount(Accounts accounts);
    void deleteAccountById(Long accountId);
    Accounts updateAccount(Accounts accounts);

}
