package com.petrius.banking_system.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private int statusCode;
}
