package com.example.user.service.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(){
        super("User Not Found");
    }
}
