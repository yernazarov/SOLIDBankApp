package com.zhandos.SOLIDBankApp.accountHttpRequests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountCreateRequest {
    private String accountType;
}
