public interface Game {
    void reset();
    boolean move(int r, int c);
    boolean isOver();
    char getWinner();
    char[][] getBoard();
    Player getCurrentPlayer();
    String render();
}
