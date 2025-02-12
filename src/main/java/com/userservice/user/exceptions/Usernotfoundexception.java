package com.userservice.user.exceptions;

public class Usernotfoundexception extends RuntimeException{
    public Usernotfoundexception(String exe){
        super(exe);
    }
}
