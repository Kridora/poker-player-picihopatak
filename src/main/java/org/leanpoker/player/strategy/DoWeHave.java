package org.leanpoker.player.strategy;

import org.leanpoker.player.json.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoWeHave {
    public boolean pair(List<Card> cards) {
        Map<Integer, Integer> cardNum = new HashMap<>();
        for (Card card : cards) {
            int rank = card.getRank();
            if (cardNum.get(rank) != null) {
                cardNum.put(rank, cardNum.get(rank) + 1);
            } else {
                cardNum.put(rank, 1);
            }
        }
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 2) {
                return true;
            }
        }
        return false;
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
}
