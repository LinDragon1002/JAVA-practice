import java.util.*;

class GameLogger {
    public static void runWithWinHint(Game g) {
        int step = 0;
        while (!g.isOver()) {
            Player p = g.getCurrentPlayer();
            int[] mv = p.nextMove(g.getBoard());
            if (!g.move(mv[0], mv[1])) {
                System.out.printf("ERROR %s(%c) -> (%d,%d)%n", p.name(), p.symbol(), mv[0], mv[1]);
                System.out.println(g.render());
                continue;
            }
            step++;
            System.out.printf("STEP %d: %s(%c) -> (%d,%d)%n", step, p.name(), p.symbol(), mv[0], mv[1]);
            System.out.println(g.render());
            if (g.isOver()) {
                System.out.printf("WIN NOW: %c%n", g.getWinner());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Player playerX = new Player('X', "Alice", new int[][]{
                {0,0}, {1,1}, {2,2}
        });
        Player playerY = new Player('O', "Bob", new int[][]{
                {0,0}, {0,2}, {2,1}
        });

        Game g = new TicTacToe(playerX, playerY);
        GameLogger.runWithWinHint(g);

        System.out.println(g.getWinner());
        System.out.println(g.render());
    }
}