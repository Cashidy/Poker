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
        for (int i = 0; i < cards.getSize() - 4; i++) {
            for (int ii = i + 1; ii < cards.getSize() - 3; ii++) {
                for (int iii = ii + 1; iii < cards.getSize() - 2; iii++) {
                    for (int iv = iii + 1; iv < cards.getSize() - 1; iv++) {
                        for (int v = iv + 1; v < cards.getSize(); v++) {
                            Hand h = new Hand(cards.get(i), cards.get(ii), cards.get(iii),
                                    cards.get(iv), cards.get(v));
                            if (h.getStrength() > strength) {
                                strength = h.getStrength();
                            }
                        }
                    }
                }
            }
        }
    }
    public void printPocket() {
        System.out.println(card1 + " & " + card2);
    }
}
