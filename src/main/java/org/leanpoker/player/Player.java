package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.json.PlayerBot;
import org.leanpoker.player.strategy.DoWeHave;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        GameState gameState = new GsonBuilder().create().fromJson(request, GameState.class);
        DoWeHave doWeHave = new DoWeHave();

        PlayerBot me = gameState.getPlayers().get(gameState.getIn_action());

        if(doWeHave.pair(me.getHole_cards()))
        {
            return gameState.getCurrent_buy_in() - me.getBet() + gameState.getMinimum_raise();
        }
        
        return 0;

    }

    public static void showdown(JsonElement game) {
    }
}
