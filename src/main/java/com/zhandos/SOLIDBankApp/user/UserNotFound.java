package com.zhandos.SOLIDBankApp.user;

public class UserNotFound extends RuntimeException {
    public UserNotFound(int id) {
        super(String.format("Could not find user %d", id));
    }
}
