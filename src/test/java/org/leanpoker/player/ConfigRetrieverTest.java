package org.leanpoker.player;

import org.junit.Assert;
import org.junit.Test;
import org.leanpoker.player.config.ConfigRetriever;
import org.leanpoker.player.json.Config;

import java.io.IOException;

public class ConfigRetrieverTest {

    @Test
    public void getKeepPocketPairs() throws IOException {
        Config configRetriever = ConfigRetriever.readJsonFromUrl();
        Assert.assertEquals("OFF", configRetriever.getKEEP_POCKET_PAIRS());
    }
}
