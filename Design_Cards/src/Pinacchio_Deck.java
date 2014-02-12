import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Pinacchio_Deck extends Deck_of_cards
{
	private ArrayList<Card> p_cardList = new ArrayList<Card>();
	
	Pinacchio_Deck()
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<6; j++)
			{
				p_cardList.add (new Card(Card.p_ranks[j],Card.p_suits[i]));
				
			}
		 }		
	 }
	
	@Override
	public void sort(ArrayList<Card> sample)
	{
		
		Comparator<Card> comparator = new Comparator<Card> (){
		    public int compare(Card c1, Card c2) {
		       
		    	if (c1.getRank().equals(c2.getRank()) && c1.getSuit().equals(c2.getSuit()))
					return 0;

				//Same suit(s)
				if (c1.getSuit().equals(c2.getSuit())) {

					// find index from array

					int indexOfCard1 = -1;
					for (int i = 0; i < 6; i++) {
						if (c1.getRank().equals(Card.p_ranks[i])) {
							indexOfCard1 = i;
							break;
						}
					}

					int indexOfCard2 = -1;
					for (int i = 0; i < 6; i++) {
						if (c2.getRank().equals(Card.p_ranks[i])) {
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
						if(c1.getSuit().equals(Card.p_suits[i]))
						{
							indexOfSuit1=i;
							break;
						}
					}
					
					int indexOfSuit2=-1;
					for(int i=0;i<4;i++)
					{
						if(c2.getSuit().equals(Card.p_suits[i]))
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
			

		    	//return c2.getId() - c1.getId(); // use your logic
		   
		}
		    
		};
		

		Collections.sort(sample, comparator);
	}
	
	
	public static void main(String []args)
	{
		Pinacchio_Deck p_DOC= new Pinacchio_Deck();
		System.out.println(p_DOC.p_cardList);
		System.out.println("******AFTER SHUFFLING:");
		p_DOC.shuffle(p_DOC.p_cardList);
		System.out.println(p_DOC.p_cardList);
		System.out.println("******AFTER SORTING:");
		p_DOC.sort(p_DOC.p_cardList);
		System.out.println(p_DOC.p_cardList);

	}

}
