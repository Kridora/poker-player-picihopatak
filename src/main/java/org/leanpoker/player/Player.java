package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.strategy.DoWeHave;
import org.leanpoker.player.strategy.Strategy;

public class Player {

    static final String VERSION = "pair";

    public static int betRequest(JsonElement request) {

        GameState gameState = new GsonBuilder().create().fromJson(request, GameState.class);
        DoWeHave doWeHave = new DoWeHave();
        
        return new Strategy().getBet(doWeHave, gameState);
    }

    public static void showdown(JsonElement game) {
    }
}
