package com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
