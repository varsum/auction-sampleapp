package pl.epoint.academy.auction.domain

import java.sql.Timestamp

/**
 * Sample auciton bidding facade
 *
 * @author dchojnacki
 */
public class AuctionBiddingFacade {

    public AuctionBid bid(Integer auctionId, Integer userId, BigDecimal bid) {
        // some business logic
        if (userId == 100_001){
            throw new AuctionBiddingOperationException('Your bid has been rejected due to too low bid value',
                                                        AuctionBiddingOperationException.Reason.BID_TOO_LOW)
        }
        return AuctionBid.of(auctionId, userId, bid, new Timestamp(new Date().getTime()))
    }
}
