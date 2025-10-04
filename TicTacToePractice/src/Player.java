public class Player {
    char sym;
    String name;
    int[][] script;
    private int moveIndex = 0;

    public Player(char sym , String name, int[][] script) {
        this.sym = sym;
        this.name = name;
        this.script = script;
    }

    public char symbol() {
        return this.sym;
    }

    public String name() {
        return this.name;
    }

    public int[] nextMove(char[][] board) {
        if (moveIndex < script.length) {
            return script[moveIndex++];
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
