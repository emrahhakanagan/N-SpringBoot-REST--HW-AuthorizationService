package com.agan.restauthorizationservice.service;

import com.agan.restauthorizationservice.enums.Authorities;
import com.agan.restauthorizationservice.exception.InvalidCredentials;
import com.agan.restauthorizationservice.exception.UnauthorizedUser;
import com.agan.restauthorizationservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final UserRepository userRepository;

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9]{6,}$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$");

    private static final String MESSAGE_USERNAME_MUST_BE =
            "Invalid username! The username must contain at least 6 characters " +
            "and not include special characters and word 'admin'";

    private static final String MESSAGE_PASSWORD_MUST_BE =
            "Invalid password! The password must: contain at least 6 characters, " +
            "include at least one digit, and have both lower and upper case letters.";


    public List<Authorities> getAuthorities(String user, String password) {
        if (isFalseUsername(user)) {
            throw new InvalidCredentials(MESSAGE_USERNAME_MUST_BE);
        }

        if (isFalsePassword(password)) {
            throw new InvalidCredentials(MESSAGE_PASSWORD_MUST_BE);
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user or incorrect password, so list of authorities is empty");
        }

        return userAuthorities;
    }

    private boolean isFalseUsername(String user) {
        return user == null || user.trim().isBlank() || !USERNAME_PATTERN.matcher(user).matches()
               || user.contains("admin");
    }

    private boolean isFalsePassword(String password) {
        return password == null || !PASSWORD_PATTERN.matcher(password).matches();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
