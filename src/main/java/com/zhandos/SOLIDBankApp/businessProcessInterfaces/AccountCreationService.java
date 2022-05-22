package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

public interface AccountCreationService {
    void create(String accountType, long bankID, String clientID, long accountID);
}
