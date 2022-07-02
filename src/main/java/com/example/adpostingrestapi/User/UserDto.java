package com.example.adpostingrestapi.User;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public record UserDto(String username, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth, String password) {
}
