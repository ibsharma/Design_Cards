/*
 *  Skypirate 
 */

import java.util.Comparator;

public class Card implements Comparable<Card> {

	private String rank;
	private String suit;
	public static String ranks[] = { "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King" };
	public static String suits[] = { "Spade", "Heart", "Club", "Diamond" };
	
	public static String p_ranks[] = {"Jack","9", "Queen", "King", "10", "Ace"  };
	public static String p_suits[] = { "Spade", "Heart", "Club", "Diamond" };


	Card(String rank, String suit) {
		this.setRank(rank);
		this.setSuit(suit);
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString()
	{
		
		return(this.rank+"of"+this.suit);
	}
	
	@Override
	public boolean equals(Object o){
		Card c = (Card)o;
		if(c.suit.equals(this.suit) && c.rank.equals(this.rank))
			return true;
		else
			return false;
	}
	

	@Override
	public int compareTo(Card o) {

		//Same card(s)
		if (this.rank.equals(o.rank) && this.suit.equals(o.suit))
			return 0;

		//Same suit(s)
		if (this.suit.equals(o.suit)) {

			// find index from array

			int indexOfCard1 = -1;
			for (int i = 0; i < 13; i++) {
				if (this.rank.equals(ranks[i])) {
					indexOfCard1 = i;
					break;
				}
			}

			int indexOfCard2 = -1;
			for (int i = 0; i < 13; i++) {
				if (o.rank.equals(ranks[i])) {
					indexOfCard2 = i;
					break;
				}
			}

			if (indexOfCard1 > indexOfCard2) {
				return 1;
			} else if (indexOfCard1 < indexOfCard2) {
				return -1;
			} else
				return 0;

		}
		//Different suit(s)
		else{
			int indexOfSuit1=-1;
			for(int i=0;i<4;i++)
			{
				if(this.suit.equals(suits[i]))
				{
					indexOfSuit1=i;
					break;
				}
			}
			
			int indexOfSuit2=-1;
			for(int i=0;i<4;i++)
			{
				if(o.suit.equals(suits[i]))
				{
					indexOfSuit2=i;
					break;
				}
			}
			
			if (indexOfSuit1 > indexOfSuit2) {
				return 1;
			} else if (indexOfSuit1 < indexOfSuit2) {
				return -1;
			} else
				return 0;
		}
	}

	}


