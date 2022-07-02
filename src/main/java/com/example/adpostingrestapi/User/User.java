package com.example.adpostingrestapi.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor // for UserDetails
@JsonIgnoreProperties("password")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING) private UserRole role;
    private String password;
    private LocalDateTime timeRegistered;
    private boolean isAccountLocked;
    private boolean isAccountEnabled;

    protected User (UserRegistrationDto newUserInfo){
        // for registration dto
        // implement role logic
        this.username = newUserInfo.getUsername();
        this.dateOfBirth = newUserInfo.getDateOfBirth();
        this.password = newUserInfo.getPassword();
        this.timeRegistered = LocalDateTime.now();
    }
}
