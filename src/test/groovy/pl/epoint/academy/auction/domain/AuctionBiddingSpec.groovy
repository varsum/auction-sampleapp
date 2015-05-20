package pl.epoint.academy.auction.domain

import spock.lang.*

import com.manning.spock.chapter5.tables.Adder

class AuctionBiddingSpec extends Specification{

	def "User bids in auction and it succeed."() {
		given: "an identity of an user and an identity of an auction"
        and: "bidding facade"
        when: "user bids on a auction"
        then: "last bid is from that user"
        and: "last price of bid is from that user"
	}

    def "User bids in auction and it is not highest bid"() {
        given: "an identity of an user and an identity of an auction"
        and: "bidding facade"
        when: "user bids on a auction"
        then: "user get info about highest bid in auction"
        and: "last bid is from another user"
        and: "last price of bid is unchanged"
    }
	
	
}

