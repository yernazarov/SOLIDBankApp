package com.zhandos.SOLIDBankApp.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.AccountType;
import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
