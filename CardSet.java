import java.util.ArrayList;
import java.util.LinkedList;

public class CardSet {
    ArrayList<Card> cards = new ArrayList<Card>();

    public CardSet() {

    }
    public CardSet(Card ... cardArray) {
        for (Card c: cardArray) {
            cards.add(c);
        }
    }
    public CardSet(ArrayList<Card> cardArray) {
        for (Card c: cardArray) {
            cards.add(c);
        }
    }
    public CardSet(CardSet cs) {
        for (int i = 0; i < cs.getSize(); i++) {
            cards.add(cs.cards.get(i));
        }
    }

    public void add(Card c) {
        cards.add(c);
    }

    public Card get(int index) {
        return cards.get(index);
    }
    
    public int getSize() {
        return cards.size();
    }

    public void shuffle() {
        LinkedList<Card> tempSet = new LinkedList<>();
        tempSet.addAll(cards);
        cards.clear();
        int index;
        while (!tempSet.isEmpty()) {
            index = (int) (Math.random() * tempSet.size());
            cards.add(tempSet.remove(index));
        }
    }

    public void sort() {
        boolean flip = true;
        while (flip) {
            flip = false;
            for (int i = 0; i < cards.size() - 1; i++) {
                if (cards.get(i).value.compareTo(cards.get(i + 1).value) < 0) {
                    swap(i, i + 1);
                    flip = true;
                }
            }
        }
    }
    private void swap(int index1, int index2) {
        Card temp = new Card(cards.get(index1).value, cards.get(index1).suit);
        cards.set(index1, cards.get(index2));
        cards.set(index2, temp);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (Card c: cards) {
            toReturn += c.toString() + ", ";
        }
        return toReturn;
    }
}
