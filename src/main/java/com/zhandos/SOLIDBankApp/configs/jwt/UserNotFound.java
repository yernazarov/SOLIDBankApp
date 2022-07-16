package com.zhandos.SOLIDBankApp.configs.jwt;

public class UserNotFound extends RuntimeException {
    public UserNotFound(int id) {
        super(String.format("Could not find user %d", id));
    }
}
