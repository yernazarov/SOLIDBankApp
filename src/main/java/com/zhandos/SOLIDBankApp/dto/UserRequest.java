package com.zhandos.SOLIDBankApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}