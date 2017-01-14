package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.json.PlayerBot;
import org.leanpoker.player.strategy.DoWeHave;

public class Player {

    static final String VERSION = "pair";

    public static int betRequest(JsonElement request) {
/*
        GameState gameState = new GsonBuilder().create().fromJson(request, GameState.class);
        DoWeHave doWeHave = new DoWeHave();

        PlayerBot me = gameState.getPlayers().get(gameState.getIn_action());
        if (false) {

            Integer x = Player.getBet(doWeHave, me, gameState);
            if (x != null) return x;

        }
        if (doWeHave.pair(me.getHole_cards())) {
            return minimumRaise(gameState, me);
        }
        */
        return 0;

    }

    public static Integer getBet(DoWeHave doWeHave, PlayerBot me, GameState gameState) {
        if (doWeHave.premiumCards(me.getHole_cards())) {
            if (doWeHave.pair(me.getHole_cards())) {
                return minimumRaise(gameState, me);
            }
            return call(gameState, me);
        }
        if (doWeHave.pair(me.getHole_cards())) {
            return call(gameState, me);
        }
        return null;
    }

    private static int minimumRaise(GameState gameState, PlayerBot me) {
        return gameState.getCurrent_buy_in() - me.getBet() + gameState.getMinimum_raise();
    }

    private static int call(GameState gameState, PlayerBot me) {
        return gameState.getCurrent_buy_in() - me.getBet();
    }

    public static void showdown(JsonElement game) {
    }
}
