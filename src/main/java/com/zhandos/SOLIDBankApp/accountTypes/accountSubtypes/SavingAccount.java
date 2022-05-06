package com.zhandos.SOLIDBankApp.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.AccountType;
import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
