package org.leanpoker.player.json;


public class Config {
    private String KEEP_POCKET_PAIRS;
    private String ALL_IN_LIMIT_IN_BB;

    public Config(String KEEP_POCKET_PAIRS) {
        this.KEEP_POCKET_PAIRS = KEEP_POCKET_PAIRS;
        this.ALL_IN_LIMIT_IN_BB = ALL_IN_LIMIT_IN_BB;
    }

    public String getKEEP_POCKET_PAIRS() {
        return KEEP_POCKET_PAIRS;
    }

    public String getALL_IN_LIMIT_IN_BB() {
        return ALL_IN_LIMIT_IN_BB;
    }
}
