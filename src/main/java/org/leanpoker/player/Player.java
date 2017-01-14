package org.leanpoker.player;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.leanpoker.player.json.GameState;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        GameState gameState = new GsonBuilder().create().fromJson(request, GameState.class);

        return 0;

    }

    public static void showdown(JsonElement game) {
    }
}
