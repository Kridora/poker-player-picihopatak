package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.leanpoker.player.json.GameState;
import org.leanpoker.player.strategy.DoWeHave;
import org.leanpoker.player.strategy.Strategy;

public class StrategyTest {

    public GameState defaultGameState(){
        JsonElement json = new JsonParser().parse(PlayerTest.input);
        return new GsonBuilder().create().fromJson(json, GameState.class);
    }

    @Test
    public void getBetTest(){
        Strategy strategy = new Strategy();
        DoWeHave doWeHave = new DoWeHave();
        GameState gameState = defaultGameState();

        strategy.getBet(doWeHave, gameState);
        strategy.minimumRaise(gameState);
        strategy.call(gameState);
    }
}
