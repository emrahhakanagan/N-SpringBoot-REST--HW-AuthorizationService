package com.agan.restauthorizationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
