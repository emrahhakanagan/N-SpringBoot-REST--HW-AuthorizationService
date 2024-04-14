package com.agan.restauthorizationservice.repository;

import com.agan.restauthorizationservice.entity.User;
import com.agan.restauthorizationservice.enums.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private Map<String, String> allUsers;

    public UserRepository() {
        allUsers = new HashMap<>();
        allUsers.put("aganagan", "Agan123");
        allUsers.put("hakanagan", "HakanAgan123");
        allUsers.put("emrahhakan", "emrahhakan123");
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (allUsers.containsKey(user.getUsername()) && allUsers.get(user.getUsername()).equals(user.getPassword())) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else {
            return Collections.emptyList();
        }
    }
}
