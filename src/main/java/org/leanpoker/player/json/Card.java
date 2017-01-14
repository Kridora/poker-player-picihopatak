package org.leanpoker.player.json;

/**
 * Created by Hupixel on 2017.01.14..
 */


public class Card {
    private int rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = Rank(rank);
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int Rank(String rank) {
        switch (rank) {
            case "2":
                return 2;

            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0;
        }
    }


}
