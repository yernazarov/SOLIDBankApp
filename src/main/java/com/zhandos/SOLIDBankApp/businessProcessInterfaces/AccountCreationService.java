package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
