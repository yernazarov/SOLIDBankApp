package com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String accountType, long id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
