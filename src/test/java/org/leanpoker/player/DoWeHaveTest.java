package org.leanpoker.player;

import junit.framework.Assert;
import org.junit.Test;
import org.leanpoker.player.json.Card;
import org.leanpoker.player.strategy.DoWeHave;

import java.util.ArrayList;
import java.util.List;

public class DoWeHaveTest {
    @Test
    public void doWeHavePairs(){
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("2", "hearts"));
        cards.add(new Card("2", "pick"));

        Assert.assertEquals(true, new DoWeHave().pair(cards));
    }
    @Test
    public void dontWeHavePairs(){
        List<Card> cards = new ArrayList<>();

        cards.add(new Card("3", "hearts"));
        cards.add(new Card("2", "pick"));

        Assert.assertEquals(false, new DoWeHave().pair(cards));
    }
}
