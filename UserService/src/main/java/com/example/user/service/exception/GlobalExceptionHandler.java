package com.example.user.service.exception;

import com.example.user.service.annotation.EnableGlobalExceptionHandler;
import com.example.user.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = EnableGlobalExceptionHandler.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public User handleUserNotFoundException(UserNotFoundException msg){
        log.error(msg.getMessage());
        User user = new User();
        user.setUserId("dummy");
        user.setName("dummy name");
        user.setEmail("dummy email");
        return user;
    }
}
