package com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
