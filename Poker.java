import java.util.ArrayList;

public class Poker {
    public static void main(String[] args) {
        try {
            //playRandomHand(args);
            //blindAllIn();
            //handVsHand();

            Card card1 = new Card(Card.Value.ACE, Card.Suit.HEARTS);
            Card card2 = new Card(Card.Value.KING, Card.Suit.HEARTS);
            Player hero = new Player(card1, card2);

            Card card3 = new Card(Card.Value.TWO, Card.Suit.DIAMONDS);
            Card card4 = new Card(Card.Value.TWO, Card.Suit.SPADES);
            Player villain = new Player(card3, card4);

            Deck deck = new Deck();
            deck.remove(card1);
            deck.remove(card2);
            deck.remove(card3);
            deck.remove(card4);

            int win = 0;
            int tie = 0;
            int loss = 0;
            
            int count = 0;

            for (int i = 0; i < deck.getSize() - 4; i++) {
                for (int ii = i + 1; ii < deck.getSize() - 3; ii++) {
                    for (int iii = ii + 1; iii < deck.getSize() - 2; iii++) {
                        for (int iv = iii + 1; iv < deck.getSize() - 1; iv++) {
                            for (int v = iv + 1; v < deck.getSize(); v++) {
                                CardSet board = new CardSet();
                                board.add(deck.get(i));
                                board.add(deck.get(ii));
                                board.add(deck.get(iii));
                                board.add(deck.get(iv));
                                board.add(deck.get(v));

                                hero.findStrength(board);
                                villain.findStrength(board);
                                if (hero.getStrength() > villain.getStrength()) {
                                    win++;
                                } else if (hero.getStrength() < villain.getStrength()) {
                                    loss++;
                                } else {
                                    tie++;
                                }
                                count++;
                            }
                        }
                    }
                }
            }

            System.out.println("\n\n");
            System.out.print("   Hero:    ");
            hero.printPocket();
            System.out.print("   Villain: ");
            villain.printPocket();
            System.out.println();
            System.out.println("     Win prob:  " + ((float)win/count * 100) + "%");
            System.out.println("     Tie prob:  " + ((float)tie/count * 100) + "%");
            System.out.println("     Loss prob: " + ((float)loss/count * 100) + "%");
            System.out.println("\n\n");

        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public static void handVsHand() {
        Card card1 = new Card(Card.Value.ACE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.Value.QUEEN, Card.Suit.HEARTS);
        Player hero = new Player(card1, card2);

        Card card3 = new Card(Card.Value.ACE, Card.Suit.DIAMONDS);
        Card card4 = new Card(Card.Value.KING, Card.Suit.DIAMONDS);
        Player villain = new Player(card3, card4);

        int win = 0;
        int tie = 0;
        int loss = 0;
            
        int numSims = 1000000;
            
        for (int i = 0; i < numSims; i++) {
            Deck deck = new Deck();
            deck.remove(card1);
            deck.remove(card2);
            deck.remove(card3);
            deck.remove(card4);
            deck.shuffle();
            CardSet board = new CardSet();
            for (int j = 0; j < 5; j++) {
                board.add(deck.deal());
            }
            hero.findStrength(board);
            villain.findStrength(board);
            if (hero.getStrength() > villain.getStrength()) {
                win++;
            } else if (hero.getStrength() < villain.getStrength()) {
                loss++;
            } else {
                tie++;
            }
        }

        System.out.println("\n\n");
        System.out.println("  Simulations run: " + numSims);
        System.out.print("     Hero: ");
        hero.printPocket();
        System.out.print("  Villain: ");
        villain.printPocket();
        System.out.println("     Win prob:  " + ((float)win/numSims * 100) + "%");
        System.out.println("     Tie prob:  " + ((float)tie/numSims * 100) + "%");
        System.out.println("     Loss prob: " + ((float)loss/numSims * 100) + "%");
        System.out.println("\n\n");
        
    }

    public static void blindAllIn() {
        Card card1 = new Card(Card.Value.SIX, Card.Suit.HEARTS);
        Card card2 = new Card(Card.Value.NINE, Card.Suit.HEARTS);
        Player hero = new Player(card1, card2);

        int win = 0;
        int tie = 0;
        int loss = 0;
            
        int numSims = 1000000;
            
        for (int i = 0; i < numSims; i++) {
            Deck deck = new Deck();
            deck.remove(card1);
            deck.remove(card2);
            deck.shuffle();
            CardSet board = new CardSet();
            Player villain = new Player(deck.deal(), deck.deal());
            for (int j = 0; j < 5; j++) {
                board.add(deck.deal());
            }
            hero.findStrength(board);
            villain.findStrength(board);
            if (hero.getStrength() > villain.getStrength()) {
                win++;
            } else if (hero.getStrength() < villain.getStrength()) {
                loss++;
            } else {
                tie++;
            }
        }
            
        System.out.println("\n\n");
        System.out.println("   Simulations run: " + numSims);
        System.out.print("   Hand: ");
        hero.printPocket();
        System.out.println("     Win prob:  " + ((float)win/numSims * 100) + "%");
        System.out.println("     Tie prob:  " + ((float)tie/numSims * 100) + "%");
        System.out.println("     Loss prob: " + ((float)loss/numSims * 100) + "%");
        System.out.println("\n\n");
    }

    public static void playRandomHand(String[] args) {
        int numPlayers;
            ArrayList<Player> players = new ArrayList<>();
            Deck deck = new Deck();
            CardSet board = new CardSet();

            numPlayers = Integer.parseInt(args[0]);
            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player());
            }
            deck.shuffle();
            for (Player p: players) {
                p.setCard1(deck.deal());
            }
            for (Player p: players) {
                p.setCard2(deck.deal());
            }

            deck.burn();
            board.add(deck.deal());
            board.add(deck.deal());
            board.add(deck.deal());
            deck.burn();
            board.add(deck.deal());
            deck.burn();
            board.add(deck.deal());


            System.out.println("\n");
            System.out.println(board);
            System.out.println();

            int winner = 0;
            int topStrength = 0;
            for (int i = 0; i < numPlayers; i++) {
                System.out.print("     ");
                players.get(i).printPocket();
                players.get(i).findStrength(board);
                if (players.get(i).getStrength() > topStrength) {
                    topStrength = players.get(i).getStrength();
                    winner = i;
                }
            }
            System.out.println();
            System.out.println("   Player " + (winner + 1) + " wins!");
            System.out.println("\n");
    }
}
