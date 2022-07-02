package com.example.adpostingrestapi.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@Setter
public class UserRegistrationDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  private final LocalDate dateOfBirth = LocalDate.now();
    private String password;// needs to be updated with secure password when adding user
    private final String confirmPassword;
}
