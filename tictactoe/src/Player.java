public class Player {
    char sym;
    String name;
    int[][] script;
    Player (char sym, String name , int[][] script) {
        this.sym = sym;
        this.name = name;
        this.script = script;
    }
    public char symbol() {
        //....
    }
    public String name() {
        return this.name;
    }
    public int[] nextMove(char[][] board) {
        //......
    }
}
