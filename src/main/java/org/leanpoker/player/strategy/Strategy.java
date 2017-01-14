package org.leanpoker.player.strategy;

import org.leanpoker.player.json.GameState;
import org.leanpoker.player.json.PlayerBot;

public class Strategy {
    public Integer getBet(DoWeHave doWeHave, GameState gameState) {
        PlayerBot me = gameState.getMe();
        if (doWeHave.premiumCards(me.getHole_cards())) {
            if (doWeHave.pair(me.getHole_cards())) {
                return minimumRaise(gameState);
            }
            return call(gameState);
        }
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

}
