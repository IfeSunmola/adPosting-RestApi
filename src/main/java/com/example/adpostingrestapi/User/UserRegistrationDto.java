package com.example.adpostingrestapi.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class UserRegistrationDto {
    private final String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  private final LocalDate dateOfBirth = LocalDate.now();
    private final String password;
    private final String confirmPassword;
}
