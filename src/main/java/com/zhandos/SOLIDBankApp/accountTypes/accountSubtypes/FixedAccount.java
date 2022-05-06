package com.zhandos.SOLIDBankApp.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.AccountType;
import com.zhandos.SOLIDBankApp.accountTypes.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
