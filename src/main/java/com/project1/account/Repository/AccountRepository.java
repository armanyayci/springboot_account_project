package com.project1.account.Repository;

import com.project1.account.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer>
{

}
