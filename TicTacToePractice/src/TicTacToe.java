public class TicTacToe implements Game {
    private Player x;
    private Player y;
    private char[][] board;
    private Player currentPlayer;
    private boolean gameOver;
    private char winner;

    public TicTacToe(Player x, Player y) {
        this.x = x;
        this.y = y;
        this.board = new char[3][3];
        this.currentPlayer = x;
        this.gameOver = false;
        this.winner = 'N';
        reset();
    }

    @Override
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '*';
            }
        }
        this.currentPlayer = x;
        this.winner = 'N';
    }

    @Override
    public boolean move(int r, int c) {
        char sym = currentPlayer.symbol();
        int count = 0;

        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return false;
        }
        if (board[r][c] != '*') {
            return false;
        }
        board[r][c] = sym;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == sym && board[1][j] == sym && board[2][j] == sym) {
                    winner = sym;
                }else if (board[i][0] == sym && board[i][1] == sym && board[i][2] == sym) {
                    winner = sym;
                }else if (board[i][j] != '*') {
                    count++;
                }
            }
        }

        if (board[0][0] == sym && board[1][1] == sym && board[2][2] == sym) {
            winner = sym;
        }
        if (board[0][2] == sym && board[1][1] == sym && board[2][0] == sym) {
            winner = sym;
        }

        if (count == 9) {
            winner = 'D';
        }

        if (!gameOver) {
            currentPlayer = (currentPlayer == x) ? y : x;
        }
        return true;
    }

    @Override
    public boolean isOver() {
        if (winner != 'N') {
            return true;
        }
        return gameOver;
    }

    @Override
    public char getWinner() {
        return winner;
    }

    @Override
    public char[][] getBoard() {
        return board.clone();
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String render() {
        String ans = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans += board[i][j];
            }
            ans += "\n";
        }
        return ans;
    }
}