import java.util.ArrayList;

public class Board {
    ArrayList<Card> board = new ArrayList<>();

    public Board() {
        //yeah
    }

    public Board(Board b) {
        for (int i = 0; i < b.getSize(); i++) {
            board.add(b.board.get(i));
        }
    }
    public void add(Card c) {
        board.add(c);
    }
    public void sort() {
        boolean flip = true;
        while (flip) {
            flip = false;
            for (int i = 0; i < board.size() - 1; i++) {
                if (board.get(i).value.compareTo(board.get(i + 1).value) < 0) {
                    swap(i, i + 1);
                    flip = true;
                }
            }
        }
    }
    private void swap(int index1, int index2) {
        Card temp = new Card(board.get(index1).value, board.get(index1).suit);
        board.set(index1, board.get(index2));
        board.set(index2, temp);
    }

    public Card get(int index) {
        return board.get(index);
    }
    public int getSize() {
        return board.size();
    }

    @Override
    public String toString() {
        return board.toString();
    }

    public static void main(String[] args) {
        Board b = new Board();
        Deck d = new Deck();
        d.shuffle();
        for (int i = 0; i < 5; i++)
            b.add(d.deal());
        b.sort();
        System.out.println(b);
    }
}
