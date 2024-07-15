package com.company.viettridao.models;

import com.company.viettridao.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String phoneNumber;
    private String addressId;
    private LocalDate dateOfBirth;
    private String userName;
    private String password;
    private String email;
    private Role role;

    public User(String fullName, String phoneNumber, String addressId, LocalDate dateOfBirth, String userName, String password, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
