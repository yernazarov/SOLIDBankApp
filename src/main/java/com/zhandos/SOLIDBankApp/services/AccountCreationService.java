package com.zhandos.SOLIDBankApp.services;

public interface AccountCreationService {
    void create(String accountType, long bankID, int clientID, String accountID);
}
