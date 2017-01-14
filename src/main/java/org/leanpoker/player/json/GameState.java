package org.leanpoker.player.json;

import java.util.List;

/**
 * Created by Hupixel on 2017.01.14..
 */
public class GameState
{
    private String tournament_id;
    private String game_id;
    private int round;
    private int bet_index;
    private int small_blind;
    private int orbits;
    private int dealer;
    private int current_buy_in;
    private int pot;
    private int in_action;
    private int minimum_raise;
    private List<Card> community_cards;
    private List<PlayerBot> players;

    public GameState(String tournament_id, String game_id, int round, int bet_index, int small_blind, int orbits, int dealer, int current_buy_in, int pot, int in_action, int minimum_raise, List<Card> community_cards, List<PlayerBot> players) {
        this.tournament_id = tournament_id;
        this.game_id = game_id;
        this.round = round;
        this.bet_index = bet_index;
        this.small_blind = small_blind;
        this.orbits = orbits;
        this.dealer = dealer;
        this.current_buy_in = current_buy_in;
        this.pot = pot;
        this.in_action = in_action;
        this.minimum_raise = minimum_raise;
        this.community_cards = community_cards;
        this.players = players;
    }

    public int getIn_action() {
        return in_action;
    }

    public void setIn_action(int in_action) {
        this.in_action = in_action;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getBet_index() {
        return bet_index;
    }

    public void setBet_index(int bet_index) {
        this.bet_index = bet_index;
    }

    public int getSmall_blind() {
        return small_blind;
    }

    public void setSmall_blind(int small_blind) {
        this.small_blind = small_blind;
    }

    public int getOrbits() {
        return orbits;
    }

    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public int getCurrent_buy_in() {
        return current_buy_in;
    }

    public void setCurrent_buy_in(int current_buy_in) {
        this.current_buy_in = current_buy_in;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public List<Card> getCommunity_cards() {
        return community_cards;
    }

    public void setCommunity_cards(List<Card> community_cards) {
        this.community_cards = community_cards;
    }

    public List<PlayerBot> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerBot> players) {
        this.players = players;
    }

    public int getMinimum_raise() {
        return minimum_raise;
    }

    public void setMinimum_raise(int minimum_raise) {
        this.minimum_raise = minimum_raise;
    }
}
