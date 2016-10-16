import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Uses all the attributes of the Card class
 */
public class DeckOfCards {

    private ArrayList<Card> cardList = new ArrayList<Card>();

    DeckOfCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardList.add(new Card(Card.ranks[j], Card.suits[i]));
            }
        }
    }

    public void shuffle(ArrayList<Card> sample) {
        Collections.shuffle(sample);
    }

    public void sort(ArrayList<Card> sample) {
        Collections.sort(sample);
    }

    public ArrayList<Card> cut(int cuttingIndex) {
        ArrayList<Card> cutList = new ArrayList<Card>();

        for (int i = cuttingIndex + 1; i < 52; i++) {

            cutList.add(cardList.get(i));
        }
        for (int i = 0; i <= cuttingIndex; i++) {
            cutList.add(cardList.get(i));
        }
        return cutList;
    }

    public Card Deal(ArrayList<Card> sample) {
        return sample.get(0);
    }

    public int Search(String rank, String suit) {
        return (cardList.indexOf(new Card(rank, suit)));
    }

    public static void main(String[] args) {
        DeckOfCards Doc = new DeckOfCards();
        System.out.println(Doc.cardList);
        Doc.shuffle(Doc.cardList);
        System.out.println("After Shuffling:");
        System.out.println(Doc.cardList);

        System.out.println("***************************");
        System.out.println("Deal:" + Doc.Deal(Doc.cardList));

        System.out.println("***************************AFTER CUTTING:");
        System.out.println(Doc.cut(12));
        System.out.println("*************************** AFTER SORTING:");

        Doc.sort(Doc.cardList);
        System.out.println(Doc.cardList);
        System.out.println("***************************");

    }
}
