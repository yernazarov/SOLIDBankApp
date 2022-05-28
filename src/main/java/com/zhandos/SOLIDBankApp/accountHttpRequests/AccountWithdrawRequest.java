package com.zhandos.SOLIDBankApp.accountHttpRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountWithdrawRequest {
    private double amount;
    private long accountID;
}
