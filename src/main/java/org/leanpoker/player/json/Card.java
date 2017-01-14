package org.leanpoker.player.json;

/**
 * Created by Hupixel on 2017.01.14..
 */


public class Card {
    private String rank;
    private String suit;
   
    public static enum RankEnum
    {
    	zero,
    	one,
    	two,
    	three,
    	four,
    	five,
    	six,
    	seven,
    	eight,
    	nine,
    	ten,
    	Jack,
    	Queen,
    	King,
    	Ace	
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public RankEnum getRankEnum(){
        return Rank(this.rank);
    }

    public RankEnum Rank(String rank) {
        switch (rank) {
            case "2":
			return RankEnum.two;
            case "3":
			return RankEnum.three;			
            case "4":
			return RankEnum.four;			
            case "5":
			return RankEnum.five;			
            case "6":
			return RankEnum.six;			
            case "7":
			return RankEnum.seven;			
            case "8":
			return RankEnum.eight;			
            case "9":
			return RankEnum.nine;			
            case "10":
			return RankEnum.ten;			
            case "J":
			return RankEnum.Jack;			
            case "Q":
			return RankEnum.Queen;			
            case "K":
			return RankEnum.King;			
            case "A":
			return RankEnum.Ace;			
            default:
                return RankEnum.zero;
        }
    }


}
