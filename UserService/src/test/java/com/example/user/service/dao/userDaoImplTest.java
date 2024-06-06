package com.example.user.service.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class userDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testCustomQuery(){
//        System.out.println(userDao.getUserByEmail2("abc@gmail.com"));
//        System.out.println(userDao.getUserByEmail2("abc2@gmail.com"));
//        System.out.println(userDao.getUserByEmail2("abc3@gmail.com"));
    }

    @Test
    public void testCustomQuery2(){
//        System.out.println(userDao.getUserByEmail3("abc@gmail.com"));
//        System.out.println(userDao.getUserByEmail3("abc2@gmail.com"));
//        System.out.println(userDao.getUserByEmail3("abc3@gmail.com"));
    }
}