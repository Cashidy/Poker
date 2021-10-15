public class Player {
    private Card card1;
    private Card card2;
    private int strength;

    public Player() {}

    public Player(Card c1, Card c2) {
        card1 = c1;
        card2 = c2;
    }
    
    public void setCard1(Card a) {
        card1 = a;
    }
    public void setCard2(Card a) {
        card2 = a;
    }
    public Card getCard1() {
        return card1;
    }
    public Card getCard2() {
        return card2;
    }
    
    public int getStrength() {
        return strength;
    }
    public void findStrength(CardSet board) {
        strength = 0;
        CardSet cards = new CardSet(board);
        cards.add(card1);
        cards.add(card2);
        cards.sort();
        int cardsSize = cards.getSize();
        Hand h = new Hand();
        for (int i = 0; i < cardsSize - 4; i++) {
            h.add(cards.get(i));
            for (int ii = i + 1; ii < cardsSize - 3; ii++) {
                h.add(cards.get(ii));
                for (int iii = ii + 1; iii < cardsSize - 2; iii++) {
                    h.add(cards.get(iii));
                    for (int iv = iii + 1; iv < cardsSize - 1; iv++) {
                        h.add(cards.get(iv));
                        for (int v = iv + 1; v < cardsSize; v++) {
                            h.add(cards.get(v));
                            h.findStrength();
                            if (h.getStrength() > strength) {
                                strength = h.getStrength();
                            }
                            h.remove(4);
                        }
                        h.remove(3);
                    }
                    h.remove(2);
                }
                h.remove(1);
            }
            h.remove(0);
        }
    }
    public void printPocket() {
        System.out.println(card1 + " & " + card2);
    }
}
