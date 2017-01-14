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
    
    public int Rank(String rank)
    {
    	switch (rank) {
		case "2":
			return 2;			
			break;
		case "3":
			return 3;			
			break;
		case "4":
			return 4;			
			break;
		case "5":
			return 5;			
			break;
		case "6":
			return 6;			
			break;
		case "7":
			return 7;			
			break;
		case "8":
			return 8;			
			break;
		case "9":
			return 9;			
			break;
		case "10":
			return 10;			
			break;
		case "J":
			return 11;			
			break;
		case "Q":
			return 12;			
			break;
		case "K":
			return 13;			
			break;
		case "A":
			return 14;			
			break;
			
			

		default:
			break;
		}
    }
    
}
