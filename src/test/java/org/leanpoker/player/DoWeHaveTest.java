package org.leanpoker.player;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.leanpoker.player.factories.CardsFactoryForTest;
import org.leanpoker.player.json.Card;
import org.leanpoker.player.strategy.DoWeHave;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DoWeHaveTest {
    private CardsFactoryForTest cardFactoryForTests;

    @Before
    public void init() {
        cardFactoryForTests = new CardsFactoryForTest();
    }

    @Test
    public void doWeHavePairs() {
        List<Card> cards = cardFactoryForTests.getAPair("small");

        assertEquals(true, new DoWeHave().pair(cards));
    }

    @Test
    public void dontWeHavePairs() {
        List<Card> cards = cardFactoryForTests.getNothing(2);

        Assert.assertEquals(false, new DoWeHave().pair(cards));
    }

    @Test
    public void doWeHavePremiumCards() {
        List<Card> cards = cardFactoryForTests.getPremiumCards();
        assertEquals(true, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void dontWeHavePremiumCards() {
        List<Card> cards = cardFactoryForTests.getNothing(2);

        assertEquals(false, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void dontWeHavePremiumCards2() {
        List<Card> cards = cardFactoryForTests.getAPair("small");

        Assert.assertEquals(false, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void doWeHaveTripleCards() {
        List<Card> cards = cardFactoryForTests.getTriple();

        Assert.assertEquals(true, new DoWeHave().triple(cards));
    }

    @Test
    public void dontWeHaveTripleCards() {
        List<Card> cards = cardFactoryForTests.getNothing(5);
        Assert.assertEquals(false, new DoWeHave().triple(cards));
    }

    @Test
    public void doWeHaveFullHouse() {
        List<Card> cards = cardFactoryForTests.getFullHouse();
        Assert.assertEquals(true, new DoWeHave().fullHouse(cards));
    }

    @Test
    public void dontWeHaveFullHouse() {
        List<Card> cards = cardFactoryForTests.getNothing(5);

        Assert.assertEquals(false, new DoWeHave().fullHouse(cards));
    }

    @Test
    public void doWeHaveTwoPair() {
        List<Card> cards = cardFactoryForTests.getTwoPairs();

        Assert.assertEquals(true, new DoWeHave().twoPair(cards));
    }

    @Test
    public void dontWeHaveTwoPair() {
        List<Card> cards = cardFactoryForTests.getNothing(5);

        Assert.assertEquals(false, new DoWeHave().twoPair(cards));
    }

    @Test
    public void doWeHaveFlush() {
        List<Card> cards = cardFactoryForTests.getFlushCards();

        Assert.assertEquals(true, new DoWeHave().flush(cards));
    }
}



