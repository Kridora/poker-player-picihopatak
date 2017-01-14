package org.leanpoker.player.strategy;

import org.leanpoker.player.json.Card;
import org.leanpoker.player.json.Card.RankEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoWeHave {


    public boolean pair(List<Card> cards) {
        Map<RankEnum, Integer> cardNum = cardCount(cards);
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean bigPair(List<Card> cards, List<Card> community_cards) {
        Map<RankEnum, Integer> cardNum = cardCount(cards);
        for (Map.Entry<RankEnum, Integer> card : cardNum.entrySet()) {
            if (card.getValue() == 2 && card.getKey().compareTo(RankEnum.ten) >= 0 && !pair(community_cards)) {
                return true;
            }
        }
        return false;
    }

    public boolean onePremiumCard(List<Card> cards) {
        int numOfPremiumCard = 0;
        for (Card card : cards) {
            if (card.getRankEnum().compareTo(RankEnum.Jack) >= 0) {
                numOfPremiumCard++;
            }
        }
        if (numOfPremiumCard >= 1) {
            return true;
        }
        return false;
    }

    public String whatDoWeHaveMax(List<Card> cards, List<Card> community_cards) {
        String whatWeHave = "";
        if (pair(cards)) {
            whatWeHave = "pair";
        }
        if (bigPair(cards, community_cards)) {
            whatWeHave = "bigPair";
        }
        if (twoPair(cards)) {
            whatWeHave = "twopair";
        }
        if (triple(cards)) {
            whatWeHave = "drill";
        }
        if (fullHouse(cards)) {
            whatWeHave = "fullhouse";
        }
        return whatWeHave;

    }

    private Map<RankEnum, Integer> cardCount(List<Card> cards) {
        Map<RankEnum, Integer> cardNum = new HashMap<>();
        for (Card card : cards) {
            RankEnum rank = card.getRankEnum();
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
            if (card.getRankEnum().compareTo(RankEnum.ten) >= 0) {
                numOfPremiumCard++;
            }
        }
        if (numOfPremiumCard >= 2) {
            return true;
        }
        return false;
    }

    public boolean triple(List<Card> cards) {
        Map<RankEnum, Integer> cardNum = cardCount(cards);
        for (int cardNumber : cardNum.values()) {
            if (cardNumber == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair(List<Card> cards) {
        int pairs = 0;
        Map<RankEnum, Integer> cardNum = cardCount(cards);
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
