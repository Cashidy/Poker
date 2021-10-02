import java.util.ArrayList;

public class Poker {
    static int numPlayers;
    static ArrayList<Player> players = new ArrayList<>();
    static Deck deck = new Deck();
    static Board board = new Board();
    public static void main(String[] args) {
        try {
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

        } catch (Exception e) {
            System.err.print(e);
        }
    }
}