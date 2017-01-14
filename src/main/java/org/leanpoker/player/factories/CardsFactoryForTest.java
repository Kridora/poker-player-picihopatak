package org.leanpoker.player.factories;

import org.leanpoker.player.json.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hupixel on 2017.01.14..
 */
public class CardsFactoryForTest {
    private List<Card> cards = new ArrayList<>();

    public List<Card> getAPair(String smallOrHigh) {
        if (smallOrHigh.equals("small")) {
            cards.add(new Card("4", "pick"));
            cards.add(new Card("4", "hearts"));
            return cards;
        } else {
            cards.add(new Card("10", "pick"));
            cards.add(new Card("10", "hearts"));
            return cards;
        }
    }

    public List<Card> getTwoPairs() {

        cards.add(new Card("10", "pick"));
        cards.add(new Card("10", "hearts"));
        cards.add(new Card("5", "hearts"));
        cards.add(new Card("5", "pick"));
        cards.add(new Card("3", "pick"));
        return cards;
    }

    public List<Card> getTriple() {

        cards.add(new Card("3", "pick"));
        cards.add(new Card("10", "hearts"));
        cards.add(new Card("5", "hearts"));
        cards.add(new Card("5", "pick"));
        cards.add(new Card("5", "clubs"));
        return cards;
    }

    public List<Card> getFullHouse() {

        cards.add(new Card("10", "pick"));
        cards.add(new Card("10", "hearts"));
        cards.add(new Card("5", "hearts"));
        cards.add(new Card("5", "pick"));
        cards.add(new Card("5", "clubs"));
        return cards;
    }

    public List<Card> getPremiumCards() {

        cards.add(new Card("A", "pick"));
        cards.add(new Card("10", "hearts"));

        return cards;
    }

    public List<Card> getNothing(int twoOrFive) {

        if (twoOrFive == 5) {
            cards.add(new Card("2", "pick"));
            cards.add(new Card("10", "hearts"));
            cards.add(new Card("4", "hearts"));
            cards.add(new Card("3", "hearts"));
            cards.add(new Card("7", "hearts"));
            return cards;
        } else {
            cards.add(new Card("4", "pick"));
            cards.add(new Card("7", "hearts"));

            return cards;
        }

    }
}
