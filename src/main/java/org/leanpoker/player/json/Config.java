package org.leanpoker.player.json;

/**
 * Created by kissbalazs on 2017. 01. 14..
 */
public class Config {
    private String KEEP_POCKET_PAIRS;

    public Config(String KEEP_POCKET_PAIRS) {
        this.KEEP_POCKET_PAIRS = KEEP_POCKET_PAIRS;
    }

    public String getKEEP_POCKET_PAIRS() {
        return KEEP_POCKET_PAIRS;
    }
}
