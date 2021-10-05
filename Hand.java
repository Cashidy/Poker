import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    int strength = 0;
    handType type;

    public enum handType {
        HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT,
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;

        public int baseStrength() {
            switch (this) {
                case STRAIGHT_FLUSH: return 770280;
                case FOUR_OF_A_KIND: return 770110;
                case FULL_HOUSE: return 769943;
                case FLUSH: return 401340;
                case STRAIGHT: return 401330;
                case THREE_OF_A_KIND: return 399146;
                case TWO_PAIR: return 396965;
                case PAIR: return 368603;
                default: return 0;
            }
        }
    }

    public Hand(ArrayList<Card> cards) {
        if (cards.size() == 5) {
            this.cards = cards;
            sort();
        } else {
            throw new IllegalArgumentException("Tried to create a hand with an array containing " +
                    cards.size() + " cards. Hands must be made of 5 cards.");
        }
    }

    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        sort();
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


    public int getStrength() {
        if (strength == 0) {
            this.findStrength();
        }
        return strength;
    }
    private void findStrength() {
        boolean suited = checkFlush();
        boolean sequential = checkStraight();
        int matches = checkMatches();
        
        if (suited && sequential) {
            type = handType.STRAIGHT_FLUSH;
            strength += type.baseStrength() + cards.get(4).value.ordinal(); 
            return; //low ace strength adjustment accounted for in checkStraight();
        }
        if (matches > 12) { //four of a kind
            type = handType.FOUR_OF_A_KIND;
            strength += type.baseStrength();

            strength += cards.get(1).value.ordinal() * 13;
            if (matches == 13) {
                strength += cards.get(4).value.ordinal();
                return;
            }
            strength += cards.get(0).value.ordinal();
            return;
        }
        if (matches > 10) { //full house       // 2-3 = 11, 3-2 = 12
            type = handType.FULL_HOUSE;
            strength += type.baseStrength();

            strength += cards.get(2).value.ordinal() * 13;
            if (matches == 11) {
                strength += cards.get(0).value.ordinal();
                return;
            }
            strength += cards.get(3).value.ordinal();
            return;
        }
        if (suited) { //flush
            type = handType.FLUSH;
            strength += type.baseStrength();
            for (int i = 0; i < 5; i++) {
                strength += cards.get(i).value.ordinal() * Math.pow(13, 4 - i);
            }
            return;
        }
        if (sequential) { //straight
            type = handType.STRAIGHT;
            strength += type.baseStrength() + cards.get(4).value.ordinal();
            return; //low ace strength adjustment accounted for in checkStraight();
        }
        if (matches > 7) { //three of a kind
            type = handType.THREE_OF_A_KIND;
            strength += type.baseStrength();

            strength += cards.get(2).value.ordinal() * 169;
            if (matches == 8) {
                strength += cards.get(3).value.ordinal() * 13;
                strength += cards.get(4).value.ordinal();
                return;
            }
            if (matches == 9) {
                strength += cards.get(0).value.ordinal() * 13;
                strength += cards.get(4).value.ordinal();
                return;
            }
            strength += cards.get(0).value.ordinal() * 13;
            strength += cards.get(1).value.ordinal();
            return;
        }
        if (matches > 4) { //two pair
            type = handType.TWO_PAIR;
            strength += type.baseStrength();

            strength += cards.get(1).value.ordinal() * 169;
            strength += cards.get(3).value.ordinal() * 13;
            if (matches == 5) {
                strength += cards.get(4).value.ordinal();
                return;
            }
            if (matches == 6) {
                strength += cards.get(2).value.ordinal();
                return;
            }
            strength += cards.get(0).value.ordinal();
            return;
        }
        if (matches > 0) { //pair
            type = handType.PAIR;
            strength += type.baseStrength();

            strength += cards.get(matches).value.ordinal() * 2197;  
            if (matches == 1) {  
                strength += cards.get(2).value.ordinal() * 169;
                strength += cards.get(3).value.ordinal() * 13;
                strength += cards.get(4).value.ordinal();
                return;
            }
            if (matches == 2) {
                strength += cards.get(0).value.ordinal() * 169;
                strength += cards.get(3).value.ordinal() * 13;
                strength += cards.get(4).value.ordinal();
                return;
            }
            if (matches == 3) {
                strength += cards.get(0).value.ordinal() * 169;
                strength += cards.get(1).value.ordinal() * 13;
                strength += cards.get(4).value.ordinal();
                return;
            }
            strength += cards.get(0).value.ordinal() * 169;
            strength += cards.get(1).value.ordinal() * 13;
            strength += cards.get(2).value.ordinal();
            return;
        }
        type = handType.HIGH_CARD;
        for (int i = 0; i < 5; i++) {
            strength += cards.get(i).value.ordinal() * Math.pow(13, 4 - i);
        }
        
    }
    private boolean checkFlush() {
        Card.Suit suit = cards.get(0).suit;
        if (cards.get(1).suit == suit && cards.get(2).suit == suit &&
                cards.get(3).suit == suit && cards.get(4).suit == suit) {
           return true;     
        }
        return false;
    }
    private boolean checkStraight() {
        int value = cards.get(0).value.ordinal();
        if (value == 12 && cards.get(1).value.ordinal() == 3 && cards.get(2).value.ordinal() == 2 &&
                cards.get(3).value.ordinal() == 1 && cards.get(4).value.ordinal() == 0) { //low ace check
            strength--;
            return true;
        }
        if (cards.get(1).value.ordinal() + 1 == value && cards.get(2).value.ordinal() + 2 == value &&
                cards.get(3).value.ordinal() + 3 == value && cards.get(4).value.ordinal() + 4 == value) { //regular check
            return true;
        }
        return false;
    }
    private int checkMatches() {
        if (cards.get(0).value == cards.get(3).value) {
            return 13;
        }                                 //four of a kinds
        if (cards.get(1).value == cards.get(4).value) {
            return 14;
        }

        int toReturn = 0;
        int pairCount = 0;
        for (int i = 0; i < 3; i++) { //trips
            if (cards.get(i).value == cards.get(i + 2).value) {
                toReturn += 4 - i;
            }
        }
        for (int i = 1; i < 5; i++) { //pairs
            if (cards.get(i - 1).value == cards.get(i).value) {
                toReturn += i;
                pairCount++;
            }
        }
        if (pairCount > 1) {
            toReturn++;
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}
