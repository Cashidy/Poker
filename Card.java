public class Card {
    public enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES;
    }
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE;
    }

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }
    public Suit getSuit() {
        return suit;
    }

    public static Value randomValue() {
        switch ((int)(Math.random() * 13)) {
            case 0: return Value.TWO;
            case 1: return Value.THREE;
            case 2: return Value.FOUR;
            case 3: return Value.FIVE;
            case 4: return Value.SIX;
            case 5: return Value.SEVEN;
            case 6: return Value.EIGHT;
            case 7: return Value.NINE;
            case 8: return Value.TEN;
            case 9: return Value.JACK;
            case 10: return Value.QUEEN;
            case 11: return Value.KING;
            default: return Value.ACE;
        }
    }

    public static Suit randomSuit() {
        switch ((int)(Math.random() * 4)) {
            case 0: return Suit.DIAMONDS;
            case 1: return Suit.CLUBS;
            case 2: return Suit.HEARTS;
            default: return Suit.SPADES;
        }
    }

    public static Card random() {
        return new Card(randomValue(), randomSuit());
    }
    
    public static boolean equals(Card c1, Card c2) {
        return c1.getValue() == c2.getValue() && c1.getSuit() == c2.getSuit();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass()) {
            Card c = (Card)o;
            if (c.getValue() == this.value && c.getSuit() == this.suit) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
