package pl.epoint.academy.auction.domain

/**
 * @author dchojnacki
 */
class AuctionBiddingSpec extends spock.lang.Specification {
    def "User bids in auction and it succeed."() {
        given: "an identity of an user and an identity of an auction"
        Integer userId = 100_000
        Integer auctionId = 12_787

        and: "a bid value"
        BigDecimal bid = 3_150

        and: "bidding facade"
        AuctionBiddingFacade biddingFacade = new AuctionBiddingFacade()

        when: "user bids on an auction"
        AuctionBid userBid = biddingFacade.bid(auctionId, userId, bid)

        then: "last bid is from that user"
        userId == userBid.userId

        then: "last bid is of price given by that user"
        bid == userBid.bid
    }

    def "User bids in auction and it's bid is too low."() {
        given: "an identity of an user and an identity of an auction"
        Integer userId = 100_001
        Integer auctionId = 12_787

        and: "a bid value"
        BigDecimal bid = 3_150

        and: "bidding facade"
        AuctionBiddingFacade biddingFacade = new AuctionBiddingFacade()

        when: "user bids on an auction"
        AuctionBid userBid = biddingFacade.bid(auctionId, userId, bid)

        then: "Actual price of auction product is not changed"
        AuctionBiddingOperationException exception = thrown()
        exception.message == 'Your bid has been rejected due to too low bid value'

        and: "User bid is too low"
        exception.reason == AuctionBiddingOperationException.Reason.BID_TOO_LOW


    }
}
