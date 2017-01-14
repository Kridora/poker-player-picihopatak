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
        
        /* load config */
        if(gameState.getRound() == 0){
        	config = ConfigRetriever.readJsonFromUrl();
        }
        
        Integer bbLimit = Integer.parseInt(config.getALL_IN_LIMIT_IN_BB());
      
        if (config != null && config.getKEEP_POCKET_PAIRS().equals("ON")) {
        	if (bbLimit > 0){
        		if(bbLimit*gameState.getSmall_blind()*2< gameState.getMe().getStack()  ){
        			/*premium lap*/
        			if (doWeHave.premiumCards(gameState.getMe().getHole_cards())) {
            			return 20000;						
					}
        			else
        				return 0;        			
        		}
        	}
            return new Strategy().getBet(doWeHave, gameState);
        }
        return 0;
    }

    public static void showdown(JsonElement game) throws IOException {
        
    }
}
