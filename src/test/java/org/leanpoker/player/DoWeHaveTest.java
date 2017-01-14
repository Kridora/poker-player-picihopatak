package org.leanpoker.player;

import junit.framework.Assert;
import org.junit.Test;
import org.leanpoker.player.json.Card;
import org.leanpoker.player.strategy.DoWeHave;

import java.util.ArrayList;
import java.util.List;

public class DoWeHaveTest {
    @Test
    public void doWeHavePairs() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("2", "pick"));

        Assert.assertEquals(true, new DoWeHave().pair(cards));
    }

    @Test
    public void dontWeHavePairs() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("3", "hearts"));
        cards.add(new Card("2", "pick"));

        Assert.assertEquals(false, new DoWeHave().pair(cards));
    }

    @Test
    public void doWeHavePremiumCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("A", "hearts"));
        cards.add(new Card("10", "pick"));

        Assert.assertEquals(true, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void dontWeHavePremiumCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("3", "hearts"));
        cards.add(new Card("10", "pick"));

        Assert.assertEquals(false, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void dontWeHavePremiumCards2() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("4", "hearts"));
        cards.add(new Card("7", "pick"));

        Assert.assertEquals(false, new DoWeHave().premiumCards(cards));
    }

    @Test
    public void doWeHaveTripleCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("3", "hearts"));
        cards.add(new Card("3", "pick"));
        cards.add(new Card("5", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("A", "pick"));

        Assert.assertEquals(true, new DoWeHave().triple(cards));
    }

    @Test
    public void dontWeHaveTripleCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("10", "pick"));
        cards.add(new Card("5", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("T", "pick"));

        Assert.assertEquals(false, new DoWeHave().triple(cards));
    }

    @Test
    public void doWeHaveFullHouse() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("2", "pick"));
        cards.add(new Card("2", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("3", "pick"));

        Assert.assertEquals(true, new DoWeHave().fullHouse(cards));
    }

    @Test
    public void dontWeHaveFullHouse() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("10", "pick"));
        cards.add(new Card("2", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("3", "pick"));

        Assert.assertEquals(false, new DoWeHave().fullHouse(cards));
    }

    @Test
    public void doWeHaveTwoPair() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("10", "pick"));
        cards.add(new Card("2", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("3", "pick"));

        Assert.assertEquals(true, new DoWeHave().twoPair(cards));
    }

    @Test
    public void dontWeHaveTwoPair() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("A", "hearts"));
        cards.add(new Card("10", "pick"));
        cards.add(new Card("2", "pick"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("3", "pick"));

        Assert.assertEquals(false, new DoWeHave().twoPair(cards));
    }
}
