package com.company.viettridao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String userName;
    private String password;
    private String email;
    private ERole role;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<BidHistory> bidHistories;
    @OneToMany(mappedBy = "seller")
    @JsonIgnore
    private List<Auction> auctions;
    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private List<Transaction> transactionBuyer;
    @OneToMany(mappedBy = "seller")
    @JsonIgnore
    private List<Transaction> transactionSeller;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<WatchList> watchLists;
}
