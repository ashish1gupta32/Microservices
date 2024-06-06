package com.example.user.service.dao;

import com.example.user.service.exception.UserNotFoundException;
import com.example.user.service.model.Rating;
import com.example.user.service.model.User;
import com.example.user.service.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class userDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final RestTemplate restTemplate;

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().peek((user)->{
            List<Rating> ratings = restTemplate.getForObject("http://localhost:9080/rating/" + user.getUserId(), List.class);
            user.setRatings(ratings);
        }).toList();

    }

    @Override
    public List<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findAllUserByName(name);
    }







/*
    @Override
    public List<User> getUserByEmail2(String email) {
        String queryStr = "Select u from User u where email=:email";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public List<User> getUserByEmail3(String email) {
        String queryStr = "Select * from user  where email=:email";
        Query nativeQuery = entityManager.createNativeQuery(queryStr, User.class);
        nativeQuery.setParameter("email", email);
        return nativeQuery.getResultList();

        //2nd way
//        Query nativeQuery = entityManager.createNativeQuery(queryStr,User.class);
//        nativeQuery.setParameter("email", email);
//        return mapToUserList(nativeQuery.getResultList());
    }

    private List<User> mapToUserList(List<Object[]> resultList) {
        return resultList.stream().map(val -> {
            User user = new User();
            user.setUserId((String) val[0]);
            user.setName((String) val[1]);
            user.setEmail((String) val[2]);
            return user;
        }).toList();
    }

*/
/*
  private User getUserWithRatings(User user) {
    String response = restTemplate.getForObject("http://localhost:9080/rating/" + user.getUserId(), String.class);
    try {
        List<Rating> ratings = new ObjectMapper().readValue(response, new TypeReference<>() {
        });
        user.setRatings(ratings);
        return user;
    } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }
}
 */
}
