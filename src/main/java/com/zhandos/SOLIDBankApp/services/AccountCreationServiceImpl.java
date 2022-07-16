package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;
import com.zhandos.SOLIDBankApp.repositories.AccountRepository;
import com.zhandos.SOLIDBankApp.entities.CheckingAccount;
import com.zhandos.SOLIDBankApp.entities.FixedAccount;
import com.zhandos.SOLIDBankApp.entities.SavingAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountCreationServiceImpl implements AccountCreationService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void create(String accountType, long bankID, int clientID, String accountID) {
        Account account = switch (accountType) {
            case "SAVING" -> new SavingAccount(accountType, accountID, clientID, 0);
            case "CHECKING" -> new CheckingAccount(accountType, accountID, clientID, 0);
            case "FIXED" -> new FixedAccount(accountType, accountID, clientID, 0);
            default -> throw new IllegalStateException("Unexpected value");
        };
        accountRepository.createNewAccount(account.getId(), account.getAccountType(), account.getClientID(),
                account.getBalance(), account.isWithdrawAllowed());
    }
}
