package com.igueyetraining.helloworldrestapis.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.igueyetraining.helloworldrestapis.domain.User;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    @PostConstruct
    private void postConstruct(){
        User user1 = new User("user1", "John", "Doe", 30);
        User user2 = new User("user2", "Pierre", "Dupont", 52);
        User user3 = new User("user3", "Samuel", "Trillon", 18);
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);
        users.put(user3.getUsername(), user3);
        log.info("Add 3 users in UserService....");
    }

    public User find(String username){
        log.info("UserService find.... ");
        User user = users.get(username);
        return user;
    }   

    public boolean delete(String username){
        log.info("UserService delete.... ");
        boolean isFound = false;
        User user = users.remove(username);
        if(user != null){
            isFound = true;
        }
        return isFound;
    }   

    public User saveOrUpdate(String username, User user){
        log.info("UserService saveOrUpdate.... ");
        users.put(username, user);
        return user;
    }   
    
    public Collection<User> findAll(){
        return users.values();
    }
}
