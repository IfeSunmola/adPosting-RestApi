package com.example.adpostingrestapi.Model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor // for UserDetails
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String password;
    private boolean isAccountLocked;
    private boolean isAccountEnabled;

    public User(String username, LocalDate dateOfBirth, String password) {
        // for DTO
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
}
