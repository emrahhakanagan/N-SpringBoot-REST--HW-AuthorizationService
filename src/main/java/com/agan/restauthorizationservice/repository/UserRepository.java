package com.agan.restauthorizationservice.repository;

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

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (allUsers.containsKey(user) && allUsers.get(user).equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else {
            return Collections.emptyList();
        }
    }
}
