import java.util.Scanner;

public class RangeChart {
    boolean[][] chart;
    public RangeChart (boolean[][] chart) {
        this.chart = chart;
    }
    public RangeChart (RangeChart rc) {
        chart = new boolean[13][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                chart[i][j] = rc.chart[i][j];
            }
        }
    }

    static RangeChart rc3;
    static RangeChart rc5;
    static RangeChart rc6;
    static RangeChart rc10;
    static RangeChart rc12;
    static RangeChart rc15;
    static RangeChart rc20;
    static RangeChart rc25;
    static RangeChart rc30;
    static RangeChart rc40;
    static RangeChart rc50;
    static RangeChart rc60;
    static RangeChart rc75;

    public static void buildStandardCharts() {
        rc3 = new RangeChart(new boolean[13][13]);
        rc3.chart[Card.Value.ACE.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc3.chart[Card.Value.ACE.ordinal()][Card.Value.KING.ordinal()] = true;
        rc3.chart[Card.Value.KING.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc3.chart[Card.Value.KING.ordinal()][Card.Value.KING.ordinal()] = true;
        rc3.chart[Card.Value.QUEEN.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc3.chart[Card.Value.JACK.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc5 = new RangeChart(rc3);
        rc5.chart[Card.Value.ACE.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc5.chart[Card.Value.ACE.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc5.chart[Card.Value.QUEEN.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc5.chart[Card.Value.TEN.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc6 = new RangeChart(rc5);
        rc6.chart[Card.Value.ACE.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc6.chart[Card.Value.KING.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc6.chart[Card.Value.NINE.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc10 = new RangeChart(rc6);
        rc10.chart[Card.Value.KING.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc10.chart[Card.Value.QUEEN.ordinal()][Card.Value.KING.ordinal()] = true;
        rc10.chart[Card.Value.QUEEN.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc10.chart[Card.Value.JACK.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc10.chart[Card.Value.JACK.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc10.chart[Card.Value.EIGHT.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc10.chart[Card.Value.SEVEN.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc10.chart[Card.Value.SIX.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc12 = new RangeChart(rc10);
        rc12.chart[Card.Value.ACE.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc12.chart[Card.Value.ACE.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc12.chart[Card.Value.TEN.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc12.chart[Card.Value.FIVE.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc15 = new RangeChart(rc12);
        rc15.chart[Card.Value.KING.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc15.chart[Card.Value.QUEEN.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc15.chart[Card.Value.JACK.ordinal()][Card.Value.KING.ordinal()] = true;
        rc15.chart[Card.Value.JACK.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc15.chart[Card.Value.FOUR.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc20 = new RangeChart(rc15);
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc20.chart[Card.Value.ACE.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc20.chart[Card.Value.JACK.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc20.chart[Card.Value.TEN.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc20.chart[Card.Value.TEN.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc20.chart[Card.Value.NINE.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc20.chart[Card.Value.EIGHT.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc20.chart[Card.Value.SEVEN.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc20.chart[Card.Value.SIX.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc20.chart[Card.Value.FIVE.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc20.chart[Card.Value.THREE.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc20.chart[Card.Value.TWO.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc25 = new RangeChart(rc20);
        rc25.chart[Card.Value.TEN.ordinal()][Card.Value.KING.ordinal()] = true;
        rc25.chart[Card.Value.TEN.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc25.chart[Card.Value.TEN.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc25.chart[Card.Value.NINE.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc25.chart[Card.Value.NINE.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc25.chart[Card.Value.EIGHT.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc25.chart[Card.Value.SEVEN.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc25.chart[Card.Value.FOUR.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc30 = new RangeChart(rc25);
        rc30.chart[Card.Value.KING.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc30.chart[Card.Value.KING.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc30.chart[Card.Value.KING.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc30.chart[Card.Value.QUEEN.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc30.chart[Card.Value.JACK.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc30.chart[Card.Value.TEN.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc30.chart[Card.Value.EIGHT.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc30.chart[Card.Value.SEVEN.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc30.chart[Card.Value.SIX.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc30.chart[Card.Value.SIX.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc30.chart[Card.Value.THREE.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc40 = new RangeChart(rc30);
        rc40.chart[Card.Value.KING.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc40.chart[Card.Value.KING.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc40.chart[Card.Value.KING.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc40.chart[Card.Value.KING.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc40.chart[Card.Value.KING.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc40.chart[Card.Value.QUEEN.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc40.chart[Card.Value.JACK.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc40.chart[Card.Value.TEN.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc40.chart[Card.Value.NINE.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc40.chart[Card.Value.NINE.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc40.chart[Card.Value.EIGHT.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc40.chart[Card.Value.SEVEN.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc40.chart[Card.Value.SIX.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc40.chart[Card.Value.FIVE.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc40.chart[Card.Value.FIVE.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc40.chart[Card.Value.FIVE.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc40.chart[Card.Value.FOUR.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc40.chart[Card.Value.FOUR.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc40.chart[Card.Value.THREE.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc40.chart[Card.Value.TWO.ordinal()][Card.Value.ACE.ordinal()] = true;
        rc50 = new RangeChart(rc40);
        rc50.chart[Card.Value.QUEEN.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc50.chart[Card.Value.JACK.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc50.chart[Card.Value.JACK.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc50.chart[Card.Value.JACK.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc50.chart[Card.Value.TEN.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc50.chart[Card.Value.TEN.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc50.chart[Card.Value.NINE.ordinal()][Card.Value.KING.ordinal()] = true;
        rc50.chart[Card.Value.NINE.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc50.chart[Card.Value.NINE.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc50.chart[Card.Value.NINE.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc50.chart[Card.Value.NINE.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc50.chart[Card.Value.EIGHT.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc50.chart[Card.Value.EIGHT.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc50.chart[Card.Value.SEVEN.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc50.chart[Card.Value.SEVEN.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc50.chart[Card.Value.SIX.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc50.chart[Card.Value.SIX.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc50.chart[Card.Value.FIVE.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc60 = new RangeChart(rc50);
        rc60.chart[Card.Value.JACK.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc60.chart[Card.Value.JACK.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc60.chart[Card.Value.TEN.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc60.chart[Card.Value.TEN.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc60.chart[Card.Value.NINE.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc60.chart[Card.Value.NINE.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc60.chart[Card.Value.EIGHT.ordinal()][Card.Value.KING.ordinal()] = true;
        rc60.chart[Card.Value.EIGHT.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc60.chart[Card.Value.EIGHT.ordinal()][Card.Value.THREE.ordinal()] = true;
        rc60.chart[Card.Value.EIGHT.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc60.chart[Card.Value.SEVEN.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc60.chart[Card.Value.SEVEN.ordinal()][Card.Value.TWO.ordinal()] = true;
        rc60.chart[Card.Value.SIX.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc60.chart[Card.Value.FIVE.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc60.chart[Card.Value.FOUR.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc60.chart[Card.Value.FOUR.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc60.chart[Card.Value.THREE.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc75 = new RangeChart(rc60);
        rc75.chart[Card.Value.EIGHT.ordinal()][Card.Value.QUEEN.ordinal()] = true;
        rc75.chart[Card.Value.EIGHT.ordinal()][Card.Value.JACK.ordinal()] = true;
        rc75.chart[Card.Value.SEVEN.ordinal()][Card.Value.KING.ordinal()] = true;
        rc75.chart[Card.Value.SEVEN.ordinal()][Card.Value.TEN.ordinal()] = true;
        rc75.chart[Card.Value.SIX.ordinal()][Card.Value.KING.ordinal()] = true;
        rc75.chart[Card.Value.SIX.ordinal()][Card.Value.NINE.ordinal()] = true;
        rc75.chart[Card.Value.FIVE.ordinal()][Card.Value.KING.ordinal()] = true;
        rc75.chart[Card.Value.FIVE.ordinal()][Card.Value.EIGHT.ordinal()] = true;
        rc75.chart[Card.Value.FOUR.ordinal()][Card.Value.KING.ordinal()] = true;
        rc75.chart[Card.Value.FOUR.ordinal()][Card.Value.SEVEN.ordinal()] = true;
        rc75.chart[Card.Value.THREE.ordinal()][Card.Value.KING.ordinal()] = true;
        rc75.chart[Card.Value.THREE.ordinal()][Card.Value.SIX.ordinal()] = true;
        rc75.chart[Card.Value.THREE.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc75.chart[Card.Value.TWO.ordinal()][Card.Value.FIVE.ordinal()] = true;
        rc75.chart[Card.Value.TWO.ordinal()][Card.Value.FOUR.ordinal()] = true;
        rc75.chart[Card.Value.TWO.ordinal()][Card.Value.THREE.ordinal()] = true;
    }

    public boolean getHand(Card a, Card b) {
        int x = a.getValue().ordinal();
        int y = b.getValue().ordinal();

        if (a.getSuit() == b.getSuit()) {
            if (x > y) {
                return chart[x][y];
            }
            return chart[y][x];
        }
        if (x > y) {
            return chart[y][x];
        }
        return chart[x][y];
    }

    public static void main(String[] args) {
        buildStandardCharts();

        Scanner scanner = new Scanner(System.in);

        RangeChart rc;
        int count = 0;
        int streak = 0;
        boolean quit = false;
        String in;
        Boolean ans;
        String question;
        try {
            while (!quit) {
                int percent;
                switch ((int)(Math.random() * 13)) {
                    case 0: rc = rc3; percent = 3; break;
                    case 1: rc = rc5; percent = 5; break;
                    case 2: rc = rc6; percent = 6; break;
                    case 3: rc = rc10; percent = 10; break;
                    case 4: rc = rc12; percent = 12; break;
                    case 5: rc = rc15; percent = 15; break;
                    case 6: rc = rc20; percent = 20; break;
                    case 7: rc = rc25; percent = 25; break;
                    case 8: rc = rc30; percent = 30; break;
                    case 9: rc = rc40; percent = 40; break;
                    case 10: rc = rc50; percent = 50; break;
                    case 11: rc = rc60; percent = 60; break;
                    default: rc = rc75; percent = 75; 
                }
                Deck deck = new Deck();
                deck.shuffle();
                Card a = deck.deal();
                Card b = deck.deal();
                question = "You have " + a + " & " + b + ".\n   Best " + percent + "%? ";
                System.out.println(question);
                in = scanner.next();
                if (in.equals("quit")) {
                    quit = true;
                    break;
                } else {
                    ans = Boolean.parseBoolean(in);
                    if (ans == rc.getHand(a, b)) {
                        System.out.println("Correct");
                        streak++;
                    } else {
                        System.out.println("Incorrect");
                        streak = 0;
                    }
                    count++;
                    if (count % 25 == 0) {
                        System.out.println("You have done " + count + " problems.");
                    }
                    if (streak % 10 == 0) {
                        System.out.println("You are on a streak of " + streak + " problems.");
                    }
                    System.out.println();
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
    }
}
