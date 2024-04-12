package com.agan.restauthorizationservice.exception;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
