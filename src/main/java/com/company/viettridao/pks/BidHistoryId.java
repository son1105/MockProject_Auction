package com.company.viettridao.pks;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class BidHistoryId implements Serializable {
    private long user;
    private long auction;

    public BidHistoryId(long user, long auction) {
        this.user = user;
        this.auction = auction;
    }

    public BidHistoryId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BidHistoryId that)) return false;
        return getUser() == that.getUser() && getAuction() == that.getAuction();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getAuction());
    }
}
