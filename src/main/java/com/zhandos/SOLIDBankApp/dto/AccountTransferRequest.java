package com.zhandos.SOLIDBankApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransferRequest {
    private String destination_account_id;
    private double amount;
}
