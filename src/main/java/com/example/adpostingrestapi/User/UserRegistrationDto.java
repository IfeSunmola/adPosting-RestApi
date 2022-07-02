package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.Annotations.IsLegal;
import com.example.adpostingrestapi.User.Annotations.ValidPhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRegistrationDto{
    private static final int MINIMUM_AGE = 21;

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
    private String lastname;

    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Phone number is required")

    @ValidPhoneNumber
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @IsLegal(minimumAge = MINIMUM_AGE, message = MINIMUM_AGE + " years+ required")
    private LocalDate dateOfBirth = LocalDate.now();

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Minimum of 8 characters required")
    private String password;// not final needs to be updated with secure password when adding user

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}
