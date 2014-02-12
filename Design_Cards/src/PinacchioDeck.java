import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PinacchioDeck extends DeckOfCards {
    private ArrayList<Card> pCardList = new ArrayList<Card>();

    PinacchioDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                pCardList.add(new Card(Card.pRanks[j], Card.pSuits[i]));
            }
        }
    }
    @Override
    public void sort(ArrayList<Card> sample) {
        Comparator<Card> comparator = new Comparator<Card>() {
            public int compare(Card c1, Card c2) {

                if (c1.getRank().equals(c2.getRank()) && c1.getSuit().equals(c2.getSuit()))
                    return 0;

                //Same suit(s)
                if (c1.getSuit().equals(c2.getSuit())) {
                    // find index from array
                    int indexOfCard1 = -1;
                    for (int i = 0; i < 6; i++) {
                        if (c1.getRank().equals(Card.pRanks[i])) {
                            indexOfCard1 = i;
                            break;
                        }
                    }

                    int indexOfCard2 = -1;
                    for (int i = 0; i < 6; i++) {
                        if (c2.getRank().equals(Card.pRanks[i])) {
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
                else {
                    int indexOfSuit1 = -1;
                    for (int i = 0; i < 4; i++) {
                        if (c1.getSuit().equals(Card.pSuits[i])) {
                            indexOfSuit1 = i;
                            break;
                        }
                    }

                    int indexOfSuit2 = -1;
                    for (int i = 0; i < 4; i++) {
                        if (c2.getSuit().equals(Card.pSuits[i])) {
                            indexOfSuit2 = i;
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
        Collections.sort(sample, comparator);
    }

    public static void main(String[] args) {
        PinacchioDeck pDOC = new PinacchioDeck();
        System.out.println(pDOC.pCardList);
        System.out.println("******AFTER SHUFFLING:");
        pDOC.shuffle(pDOC.pCardList);
        System.out.println(pDOC.pCardList);
        System.out.println("******AFTER SORTING:");
        pDOC.sort(pDOC.pCardList);
        System.out.println(pDOC.pCardList);
        System.out.println("******AFTER DEALING:");
        System.out.println(pDOC.Deal(pDOC.pCardList));
    }
}
