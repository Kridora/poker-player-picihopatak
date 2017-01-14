package org.leanpoker.player.strategy;

import org.leanpoker.player.json.Card;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.json.PlayerBot;

import java.util.List;

public class Strategy {


    public Integer getBet(DoWeHave doWeHave, GameState gameState) {
        PlayerBot me = gameState.getMe();
        List<Card> cards = me.getHole_cards();

        int activePlayers = 0;
        for (PlayerBot playerBot : gameState.getPlayers()) {
            if(playerBot.getStatus().equals("active")){
                activePlayers++;
            }
        }
        if(activePlayers == 2 && doWeHave.onePremiumCard(cards)){
            return 20000;
        }


        if (isPostFlop(gameState, me)) {
            List<Card> communityCards = gameState.getCommunity_cards();
            for (Card card : communityCards) {
                cards.add(card);
            }
            int bet = 0;
            switch (doWeHave.whatDoWeHaveMax(cards)) {
                case "pair":
                    bet = 0;
                    break;
                case "bigPair":
                    bet = minimumRaise(gameState);
                    break;
                case "twopair":
                    bet = minimumRaise(gameState);
                    break;
                case "drill":
                    bet = minimumRaise(gameState);
                    break;
                case "fullhouse":
                    bet = minimumRaise(gameState);
                    break;
                default:
                    bet = 0;
                    break;
            }
            return bet;
        }

        if (doWeHave.premiumCards(me.getHole_cards())) {
            if (doWeHave.pair(me.getHole_cards())) {
                return minimumRaise(gameState);
            }
            if(gameState.getCurrent_buy_in() > gameState.getSmall_blind()*2){
            	return 0;
            }
            else {
            	return call(gameState);
            }
            
        }
        if (doWeHave.pair(me.getHole_cards())) {
            if(gameState.getCurrent_buy_in() < gameState.getSmall_blind()*4)
                return minimumRaise(gameState);
        }
        return 0;
    }

    public int getBetPairStrat(DoWeHave doWeHave, GameState gameState){
        PlayerBot me = gameState.getMe();
        if (doWeHave.pair(me.getHole_cards())) {
            return call(gameState);
        }
        return 0;
    }

    public int minimumRaise(GameState gameState) {
        PlayerBot me = gameState.getMe();
        return gameState.getCurrent_buy_in() - me.getBet() + gameState.getMinimum_raise();
    }

    public int call(GameState gameState) {
        PlayerBot me = gameState.getMe();
        return gameState.getCurrent_buy_in() - me.getBet();
    }

    public boolean isAllIn(GameState gameState, PlayerBot me) {
        if (gameState.getCurrent_buy_in() >= me.getStack()) {
            return true;
        }
        return false;
    }

    public boolean isPostFlop(GameState gameState, PlayerBot me) {
        if (gameState.getCommunity_cards().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
