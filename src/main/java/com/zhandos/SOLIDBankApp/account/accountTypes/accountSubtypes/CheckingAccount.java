package com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
