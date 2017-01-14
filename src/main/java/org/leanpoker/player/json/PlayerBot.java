package org.leanpoker.player.json;

import java.util.List;

/**
 * Created by Hupixel on 2017.01.14..
 */
public class PlayerBot {
    private String name;
    private int stack;
    private int bet;
    private String status;
    private String version;
    private int id;

    private List<Card> hole_cards;

    public PlayerBot(String name, int stack, int bet, String status, String version, int id, List<Card> hole_cards) {
        this.name = name;
        this.stack = stack;
        this.bet = bet;
        this.status = status;
        this.version = version;
        this.id = id;
        this.hole_cards = hole_cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Card> getHole_cards() {
        return hole_cards;
    }

    public void setHole_cards(List<Card> hole_cards) {
        this.hole_cards = hole_cards;
    }
}
