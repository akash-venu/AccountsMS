package com.teckarch.AccountsMS.Repository;

import com.teckarch.AccountsMS.Models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
