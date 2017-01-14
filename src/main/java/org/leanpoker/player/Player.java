package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.leanpoker.player.config.ConfigRetriever;
import org.leanpoker.player.json.Card;
import org.leanpoker.player.json.Config;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.strategy.DoWeHave;
import org.leanpoker.player.strategy.Strategy;

import java.io.IOException;

public class Player {

    static final String VERSION = "pair";
    private static Config config;

    public static int betRequest(JsonElement request) throws IOException {

        GameState gameState = new GsonBuilder().create().fromJson(request, GameState.class);
        DoWeHave doWeHave = new DoWeHave();
        
        if(gameState.getRound() == 0){
        	config = ConfigRetriever.readJsonFromUrl();
        }
      
        if (config != null && config.getKEEP_POCKET_PAIRS().equals("ON")) {
            return new Strategy().getBetPairStrat(doWeHave, gameState);
        }
        return 0;
    }

    public static void showdown(JsonElement game) throws IOException {
        
    }
}
