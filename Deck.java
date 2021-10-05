public class Deck extends CardSet {
    public Deck() {
        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Value value: Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
    public Card deal() {
        return cards.remove(cards.size() - 1);
    }
    public void burn() {
        cards.remove(cards.size() - 1);
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
