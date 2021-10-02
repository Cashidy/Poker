import java.util.LinkedList;
public class Deck {
    LinkedList<Card> cards = new LinkedList<>();
    public Deck() {
        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Value value: Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
    public void shuffle() {
        LinkedList<Card> tempDeck = new LinkedList<>();
        tempDeck.addAll(cards);
        cards.clear();
        int index;
        while (!tempDeck.isEmpty()) {
            index = (int) (Math.random() * tempDeck.size());
            cards.add(tempDeck.get(index));
            tempDeck.remove(index);
        }
    }
    public Card deal() {
        Card toReturn = cards.getFirst();
        cards.removeFirst();
        return toReturn;
    }
    public void burn() {
        cards.removeFirst();
    }
    @Override
    public String toString() {
        String toReturn = "";
        for (Card card: cards) {
            toReturn += card.toString();
            toReturn += "\n";
        }
        return toReturn;
    }
}
