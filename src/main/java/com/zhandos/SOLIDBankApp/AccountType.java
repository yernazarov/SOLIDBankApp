package com.zhandos.SOLIDBankApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AccountType {
    public String name;
    public AccountType(String name) {
        this.name = name;
    }
}
