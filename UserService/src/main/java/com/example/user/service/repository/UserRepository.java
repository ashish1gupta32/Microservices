package com.example.user.service.repository;

import com.example.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByEmail(String email);
    List<User> getUserByEmail(String email);

    @Query(value="select * from user where name=?1",nativeQuery = true)
    List<User> findAllUserByName2(String name);

    @Query(value="SELECT u FROM User u WHERE u.name=:name")
    List<User> findAllUserByName(@Param("name") String name);
}
