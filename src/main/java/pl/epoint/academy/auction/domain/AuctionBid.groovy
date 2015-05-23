package pl.epoint.academy.auction.domain

import java.sql.Timestamp

/**
 * @author dchojnacki
 */
public class AuctionBid implements Serializable{
    private final Integer auctionId;
    private final Integer userId;
    private final BigDecimal bid;
    private final Timestamp createTs;

    private AuctionBid(Integer auctionId, Integer userId, BigDecimal bid, Timestamp createTs) {
        this.auctionId = auctionId
        this.userId = userId
        this.bid = bid
        this.createTs = createTs
    }

    public static AuctionBid of(Integer auctionId, Integer userId, BigDecimal bid, Timestamp createTs) {
        return new AuctionBid(auctionId, userId, bid, createTs);
    }

    public Integer getAuctionId() {
        return auctionId
    }

    public Integer getUserId() {
        return userId
    }

    public BigDecimal getBid() {
        return bid
    }

    public Timestamp getCreateTs() {
        return createTs
    }

    @Override
    public String toString() {
        return "AuctionBid{" +
                "auctionId=" + auctionId +
                ", userId=" + userId +
                ", bid=" + bid +
                ", createTs=" + createTs +
                '}';
    }

    public boolean equals(o) {
        if (this.equals(o)) return true
        if (getClass() != o.class) return false

        AuctionBid that = (AuctionBid) o

        if (auctionId != that.auctionId) return false
        if (bid != that.bid) return false
        if (createTs != that.createTs) return false
        if (userId != that.userId) return false

        return true;
    }

    public int hashCode() {
        int result
        result = auctionId.hashCode()
        result = 31 * result + userId.hashCode()
        result = 31 * result + bid.hashCode()
        result = 31 * result + createTs.hashCode()

        return result
    }
}
