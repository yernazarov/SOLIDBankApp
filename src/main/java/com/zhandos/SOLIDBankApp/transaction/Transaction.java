package com.zhandos.SOLIDBankApp.transaction;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
public class Transaction {
    @Id String transaction;
}
