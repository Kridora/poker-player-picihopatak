package org.leanpoker.player.strategy;

import org.leanpoker.player.json.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoWeHave {
    public boolean pair(List<Card> cards) {
        Map<Integer, Integer> cardNum = cardCount(cards);
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 2) {
                return true;
            }
        }
        return false;
    }

    private Map<Integer, Integer> cardCount(List<Card> cards) {
        Map<Integer, Integer> cardNum = new HashMap<>();
        for (Card card : cards) {
            int rank = card.getRank();
            if (cardNum.get(rank) != null) {
                cardNum.put(rank, cardNum.get(rank) + 1);
            } else {
                cardNum.put(rank, 1);
            }
        }
        return cardNum;
    }

    public boolean premiumCards(List<Card> cards) {
        int numOfPremiumCard = 0;
        for (Card card : cards) {
            if (card.getRank() >= 10) {
                numOfPremiumCard++;
            }
        }
        if (numOfPremiumCard >= 2) {
            return true;
        }
        return false;
    }

    public boolean triple(List<Card> cards) {
        Map<Integer, Integer> cardNum = cardCount(cards);
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair(List<Card> cards) {
        int pairs = 0;
        Map<Integer, Integer> cardNum = cardCount(cards);
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 2) {
                pairs++;
            }
        }
        if (pairs == 2) {
            return true;
        }
        return false;
    }

    public boolean fullHouse(List<Card> cards) {
        if (pair(cards) && triple(cards)) {
            return true;
        }
        return false;
    }
}
