package com.example.user.service.controller;

import com.example.user.service.annotation.EnableGlobalExceptionHandler;
import com.example.user.service.dao.UserDao;
import com.example.user.service.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@EnableGlobalExceptionHandler
public class UserController {

    private final UserDao userDao;
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        return ResponseEntity.ok().body(userDao.getUserById(userId));
    }

    @GetMapping("/userByName/{name}")
    @RateLimiter(name="getUserByNameRateLimiter",fallbackMethod = "getUserFallBackMethod")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name){
        return ResponseEntity.ok().body(userDao.getUserByName(name));
    }

    @GetMapping
    @CircuitBreaker(name="getAllUserCircuitBreaker",fallbackMethod = "getUserFallBackMethod")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(userDao.getAllUser());
    }

    @GetMapping("/getAllUserByEmail/{email}")
    public ResponseEntity<List<User>> getALlUserByEmail(@PathVariable String email){
        return ResponseEntity.ok().body(userDao.getUserByEmail(email));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        userDao.createUser(user);
        return ResponseEntity.ok().body("Created");
    }

    public ResponseEntity<List<User>> getUserFallBackMethod(Exception ex){
        log.error("some error appeared while fetching all user={}",ex.getMessage());
        return ResponseEntity.badRequest()
                .body(List.of(new User("dummy","dummy name","dummy email",null)));
    }
}
