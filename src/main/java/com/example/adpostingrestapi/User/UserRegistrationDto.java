package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.Annotations.IsLegal;
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
@ToString
@Setter
//@FieldMatch(fieldName = "password")
public class UserRegistrationDto{
    private static final int MINIMUM_AGE = 21;

    @Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
    private final String firstname;

    @Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
    private final String lastname;

    @Email(message = "Enter a valid email")
    private final String email;

    @NotBlank(message = "Phone number is required")
    //@Size(min = 10, max = 10, message = "Phone number must be 10 numbers")
//    @Pattern(regexp = "^((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$",
//            message = "Phone number must be in form (123) 456-789")
    private final String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @IsLegal(minimumAge = MINIMUM_AGE, message = MINIMUM_AGE + " years+ required")
    private final LocalDate dateOfBirth = LocalDate.now();

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Minimum of 8 characters required")
    private String password;// not final needs to be updated with secure password when adding user
    @NotBlank(message = "Confirm password is required")

    private final String confirmPassword;

    public UserRegistrationDto(UserRegistrationDto copy){
        this.firstname = copy.firstname;
        this.lastname = copy.lastname;
        this.email = copy.email;
        this.phoneNumber = copy.phoneNumber;
        this.password = copy.password;
        this.confirmPassword = copy.confirmPassword;
    }
}
