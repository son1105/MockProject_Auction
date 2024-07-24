package com.company.viettridao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "watch-list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(WatchListId.class)
public class WatchList {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
    private LocalDateTime addDate;
}
