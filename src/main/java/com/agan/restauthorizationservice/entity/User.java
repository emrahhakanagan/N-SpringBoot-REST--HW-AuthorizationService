package com.agan.restauthorizationservice.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {
    @NotBlank(message = "Username cannot be empty")
    @Length(min = 6, message = "Username must be at least 6 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must not include special characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Length(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",
            message = "Password must include digits, lower and upper case letters")
    private long password;
}
