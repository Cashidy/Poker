import java.util.ArrayList;

public class CardSet {
    ArrayList<Card> cards = new ArrayList<Card>();

    public CardSet() {

    }
    public CardSet(CardSet cs) {
        for (int i = 0; i < cs.getSize(); i++) {
            cards.add(cs.cards.get(i));
        }
    }

    public void add(Card c) {
        cs.add(c);
    }
    public void sort() {
        boolean flip = true;
        while (flip) {
            flip = false;
            for (int i = 0; i < cs.size() - 1; i++) {
                if (cs.get(i).value.compareTo(cs.get(i + 1).value) < 0) {
                    swap(i, i + 1);
                    flip = true;
                }
            }
        }
    }
    private void swap(int index1, int index2) {
        Card temp = new Card(cs.get(index1).value, cs.get(index1).suit);
        cs.set(index1, cs.get(index2));
        cs.set(index2, temp);
    }
}
