package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.AccountType;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}
